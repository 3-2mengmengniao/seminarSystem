package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.CourseDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.dao.TeamDao;
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
import java.util.ArrayList;
import java.util.List;

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
        teamDao.deleteTeamByTeamId(teamId);
    }

    @Override
    public void updateTeam(Team team) throws TeamNotFoundException {
        teamDao.updateTeam(team);
    }

    @Override
    public void insertTeam(Team team,BigInteger courseClassId) throws RepetitiveRecordException {
        teamDao.insertTeam(team,courseClassId,courseClassDao.getCourseClassByCourseClassId(courseClassId).getCourse().getId());
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
        List<Team> teamList=teamDao.getTeamByCourseId(courseId);
        List<CourseClass> courseClassList=courseClassDao.getCourseClassByCourseId(courseId);
        List<Student> studentList=new ArrayList<>();
        List<BigInteger> studentIdList=new ArrayList<>();
        //获取课程下所有班级的学生名单(Id形式)
        for(CourseClass courseClass:courseClassList){
            for(Team classTeam:courseClass.getTeamList()) {
                studentList.addAll(classTeam.getMemberList());
            }
        }
        for(Student student:studentList){
            studentIdList.add(student.getId());
        }
        //将队伍中未选此课程的学生剔除
        for(Team team:teamList){
            List<Student> memberList=team.getMemberList();
            for(Student member:memberList){
                BigInteger memberId=member.getId();
                if(studentIdList.contains(memberId)){
                    studentList.remove(studentDao.getStudentByStudentId(memberId));
                    studentIdList.remove(memberId);
                }
                else{
                    memberList.remove(member);
                }
            }
            team.setMemberList(memberList);
        }
        Pair<List<Team>,List<Student>> pair=new Pair<>(teamList,studentList);
        return pair;
    }

    @Override
    public void addTeamMember(BigInteger teamId, BigInteger studentId) {

    }

    @Override
    public void deleteTeamMember(BigInteger teamId, BigInteger studentId) {

    }
}
