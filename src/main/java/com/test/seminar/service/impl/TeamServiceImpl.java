package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.CourseClass;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
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
    public void insertTeam(Team team,BigInteger courseClassId,List<BigInteger> memberIdList) throws RepetitiveRecordException {
        CourseClass courseClass=courseClassDao.getCourseClassByCourseClassId(courseClassId);
        teamDao.insertTeam(team,courseClassId,courseClass.getCourse().getId());
        team=teamDao.getTeamByMainCourseClassIdAndTeamSerial(courseClassId,team.getSerial().getTeamSerial());
        teamDao.insertCourseClassAndTeamRelation(courseClassId,team.getId());
        for(BigInteger memberId:memberIdList){
            teamDao.insertTeamAndStudentRelation(team.getId(),memberId);
        }
        updateTeamAboutShared(team);
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
    public List<Team> getTeam(BigInteger courseId){
        //获取课程下所有队伍（包含组员列表）
        List<Team> teamList=teamDao.getTeamByCourseId(courseId);
        List<CourseClass> courseClassList=courseClassDao.getCourseClassByCourseId(courseId);
        List<BigInteger> studentIdList=null;
        //获取课程下每个班级的学生名单(Id形式)
        for(CourseClass courseClass:courseClassList){
            List<Student> studentList=studentDao.getStudentByCourseClassId(courseClass.getId());
            for(Student student:studentList){
                studentIdList.add(student.getId());
            }
        }
        //将队伍中未选此课程的学生剔除
        for(Team team:teamList){
            List<Student> memberList=team.getMemberList();
            for(Student member:memberList){
                if(studentIdList.contains(member.getId())){
                    continue;
                }
                else{
                    memberList.remove(member);
                }
            }
            team.setMemberList(memberList);
        }
        return teamList;
    }

    @Override
    public void addTeamMember(BigInteger teamId, BigInteger studentId) {
        teamDao.insertTeamAndStudentRelation(teamId,studentId);
        Team team=teamDao.getTeamByTeamId(teamId);
        updateTeamAboutShared(team);
    }

    @Override
    public void deleteTeamMember(BigInteger teamId, BigInteger studentId) {
        teamDao.deleteTeamAndStudentRelation(teamId,studentId);
        Team team=teamDao.getTeamByTeamId(teamId);
        updateTeamAboutShared(team);
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
        CourseClass currentCourseClass=courseClassDao.getCourseClassByStudentIdAndCourseId(team.getLeader().getId(),course.getId());
        if(currentCourseClass!=null){
            teamDao.deleteCourseClassAndTeamRelation(team.getId(),currentCourseClass.getId());
        }
        List<CourseClass> courseClassList=courseClassDao.getCourseClassByCourseId(course.getId());
        Map<BigInteger,Integer> memberBelongCourseClassMap=new HashMap<>();
        for(CourseClass courseClass:courseClassList){
            memberBelongCourseClassMap.put(courseClass.getId(),0);
        }
        for(Student student:team.getMemberList()){
            BigInteger studentCourseClassId=courseClassDao.getCourseClassByStudentIdAndCourseId(student.getId(),course.getId()).getId();
            Integer count=memberBelongCourseClassMap.get(studentCourseClassId);
            count=count+1;
            memberBelongCourseClassMap.put(studentCourseClassId,count);
        }
        List<Map.Entry<BigInteger,Integer>> mapList = new ArrayList(memberBelongCourseClassMap.entrySet());
        Collections.sort(mapList, (o1, o2) -> (o2.getValue() - o1.getValue()));
        List<BigInteger> maxMemberCourseClassList=new ArrayList<>();
        Integer maxMemberCount=mapList.get(0).getValue();
        for(Map.Entry<BigInteger,Integer> mapItem:mapList){
            if(mapItem.getValue()<maxMemberCount){
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
            Collections.sort(courseClassTeamNumberList, (o1, o2) -> (o1.getValue() - o2.getValue()));
            teamDao.insertCourseClassAndTeamRelation(courseClassTeamNumberList.get(0).getKey(),team.getId());
        }
    }
}
