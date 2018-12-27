package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.service.CourseService;
import com.test.seminar.service.TeamService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private CourseClassDao courseClassDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public Team getTeamByTeamId(BigInteger teamId) throws TeamNotFoundException {
        return teamDao.getTeamByTeamId(teamId);
    }

    @Override
    public void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException {
        teamDao.deleteCourseClassAndTeamRelationByTeamId(teamId);
        teamDao.deleteTeamAndStudentRelationByTeamId(teamId);
        teamDao.deleteTeamByTeamId(teamId);
    }

    @Override
    public void updateTeam(Team team) throws TeamNotFoundException {
        teamDao.updateTeam(team);
    }

    @Override
    public void insertTeam(Team team,List<BigInteger> memberIdList) throws RepetitiveRecordException {
        team.getSerial().setTeamSerial(teamDao.getMaxTeamSerialByCourseClassId(team.getCourseClass().getId())+1);
        teamDao.insertTeam(team,team.getCourseClass().getId(),team.getCourse().getId());
        team=teamDao.getTeamByMainCourseClassIdAndTeamSerial(team.getCourseClass().getId(),team.getSerial().getTeamSerial());
        teamDao.insertCourseClassAndTeamRelation(team.getCourseClass().getId(),team.getId());
        for(BigInteger memberId:memberIdList){
            teamDao.insertTeamAndStudentRelation(team.getId(),memberId);
        }
        updateTeamAboutShared(team);
        isTeamValid(team);
    }

    @Override
    public Team getTeamByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId) throws TeamNotFoundException {
        return teamDao.getTeamByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public List<Team> getTeamByCourseId(BigInteger courseId) {
        return teamDao.getTeamByCourseId(courseId);
    }

    @Override
    public List<Team> getTeamBySeminarControlId(BigInteger seminarControlId) {
        return  teamDao.getTeamBySeminarControlId(seminarControlId);
    }

    @Override
    public Pair<List<Team>,List<Student>> getTeam(BigInteger courseId){
        //获取课程下所有队伍
        List<Team> teamList=teamDao.getGroupStudentByCourseId(courseId);
        List<Student> studentList=studentDao.getStudentNotInTeamByCourseId(courseId);
        Pair<List<Team>,List<Student>> pair=new Pair<>(teamList,studentList);
        return pair;
    }

    @Override
    public void addTeamMember(BigInteger teamId, BigInteger studentId) {
        teamDao.insertTeamAndStudentRelation(teamId,studentId);
        Team team=teamDao.getTeamByTeamId(teamId);
        updateTeamAboutShared(team);
        isTeamValid(team);
    }

    @Override
    public void deleteTeamMember(BigInteger teamId, BigInteger studentId) {
        teamDao.deleteTeamAndStudentRelation(teamId,studentId);
        Team team=teamDao.getTeamByTeamId(teamId);
        updateTeamAboutShared(team);
        isTeamValid(team);
    }

    /**
     * @author wzw
     * date 2018/12/25
     */
    @Override
    public Boolean isTeamValid(Team team) throws TeamNotFoundException {

        //获取队伍总策略
        List<TeamStrategy> teamStrategyList = teamDao.getTeamStrategyListByCourseId(team.getCourse().getId());

        //遍历每一个策略
        for (TeamStrategy teamStrategy : teamStrategyList) {
            //获得策略类名
            String strategyName = teamStrategy.getStrategyName();
            try {
                //判断该策略是否为复合策略
                Class strategyClass = Class.forName(strategyName);
                Boolean isCompositStrategy = CompositStrategy.class.isAssignableFrom(strategyClass);

                Boolean result = null;
                if (isCompositStrategy) {
                    //复合策略验证
                    result = teamDao.validCompositStrategyOnTeam(team, teamStrategy.getStrategyId(), strategyName);
                } else {
                    //简单策略验证
                    result = teamDao.validSimpleStrategyOnTeam(team, teamStrategy.getStrategyId(), strategyName);
                }

                //只要有一个策略没满足，就返回false
                if (!result) {
                    team.setStatus(0);
                    teamDao.updateTeam(team);
                    return false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //所有策略都满足，返回true
        return true;
    }

    private void updateTeamAboutShared(Team team){
        List<Course> courseList=team.getCourseClass().getCourse().getTeamSubCourseList();
        if(courseList!=null){
            for(Course course:courseList){
                updateTeamSubCourseTeamRelation(course,team);
            }
        }
    }

    private void updateTeamSubCourseTeamRelation(Course course, Team team){
        CourseClass currentCourseClass=courseClassDao.getCourseClassByTeamIdAndCourseId(team.getId(),course.getId());
        if(currentCourseClass!=null){
            teamDao.deleteCourseClassAndTeamRelation(team.getId(),currentCourseClass.getId());
        }
        List<CourseClass> courseClassList=courseClassDao.getCourseClassByCourseId(course.getId());
        Map<BigInteger,Integer> memberBelongCourseClassMap=new HashMap<>();
        for(CourseClass courseClass:courseClassList){
            memberBelongCourseClassMap.put(courseClass.getId(),0);
        }
        for(Student student:team.getMemberList()){
            CourseClass courseClass=courseClassDao.getCourseClassByStudentIdAndCourseId(student.getId(),course.getId());
            if(courseClass==null) {
                continue;
            }
            BigInteger studentCourseClassId=courseClass.getId();
            Integer count=memberBelongCourseClassMap.get(studentCourseClassId);
            count=count+1;
            memberBelongCourseClassMap.put(studentCourseClassId,count);
        }
        List<Map.Entry<BigInteger,Integer>> mapList = new ArrayList(memberBelongCourseClassMap.entrySet());
        Collections.sort(mapList, (o1, o2) -> (o2.getValue() - o1.getValue()));
        List<BigInteger> maxMemberCourseClassList=new ArrayList<>();
        Integer maxMemberCount=mapList.get(0).getValue();
        //无人在这个课程下
        if(maxMemberCount==0) {
            return;
        }
        for(Map.Entry<BigInteger,Integer> mapItem:mapList){
            if(mapItem.getValue()<=maxMemberCount){
                maxMemberCourseClassList.add(mapItem.getKey());
            }
        }
        if(maxMemberCourseClassList.size()==1){
            teamDao.insertCourseClassAndTeamRelation(maxMemberCourseClassList.get(0),team.getId());
        }
        else{
            List<Pair<BigInteger,Integer>> courseClassTeamNumberList=new ArrayList<>();
            for(BigInteger maxMemberCourseClassId:maxMemberCourseClassList){
                courseClassTeamNumberList.add(new Pair<>(maxMemberCourseClassId,courseClassDao.getCourseClassTeamNumber(maxMemberCourseClassId)));
            }
            Collections.sort(courseClassTeamNumberList, Comparator.comparingInt(Pair::getValue));
            teamDao.insertCourseClassAndTeamRelation(courseClassTeamNumberList.get(0).getKey(),team.getId());
        }
    }

    @Override
    public void insertTeamValidApplication(TeamValidApplication teamValidApplication,BigInteger teamId,BigInteger teacherId){
        teamDao.insertTeamValidApplication(teamValidApplication,teamId,teacherId);
    }

    @Override
    public List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId){
        return teamDao.getTeamValidApplicationByTeacherId(teacherId);
    }

    @Override
    public void updateTeamValidApplication(TeamValidApplication teamValidApplication){
        teamDao.updateTeamValidApplication(teamValidApplication);
        teamDao.deleteTeamValidApplicationByTeamValidApplicationId(teamValidApplication.getId());
    }
}
