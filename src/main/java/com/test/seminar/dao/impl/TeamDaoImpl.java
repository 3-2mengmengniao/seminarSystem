package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.mapper.StudentMapper;
import com.test.seminar.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class TeamDaoImpl implements TeamDao {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException {
        Team team=teamMapper.getTeamByTeamId(teamId);
        if(team==null) {
            throw new TeamNotFoundException();
        }
        return team;
    }

    @Override
    public List<Team> getTeamByCourseId(BigInteger courseId) {
       BigInteger mainCourseId=courseMapper.getTeamMainCourseIdBySubCourseId(courseId);
       if(mainCourseId==null){
           return teamMapper.getTeamByCourseId(courseId);
       }
       else{
           return teamMapper.getTeamByCourseId(mainCourseId);
       }
    }

    @Override
    public List<Team> getTeamBySeminarControlId(BigInteger seminarControlId) {
       return teamMapper.getTeamBySeminarControlId(seminarControlId);
    }

    @Override
    public Team getTeamByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId) throws TeamNotFoundException {
        Team team=teamMapper.getTeamByStudentIdAndCourseId(studentId,courseId);
        if(team==null) {
            throw new TeamNotFoundException();
        }
        return team;
    }

    @Override
    public Serial getSerialByTeamId(BigInteger teamId) {
        return teamMapper.getSerialByTeamId(teamId);
    }

    @Override
    public void insertTeam(Team team, BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException {
        teamMapper.insertTeam(team,courseClassId,courseId);
    }

    @Override
    public void updateTeam(Team team)throws TeamNotFoundException {
        if(teamMapper.getTeamByTeamId(team.getId())==null) {
            throw new TeamNotFoundException();
        }
        teamMapper.updateTeam(team);
    }

    @Override
    public void updateCourseClassStudentTeamId(BigInteger courseClassId, BigInteger studentId, BigInteger teamId) {
        teamMapper.updateCourseClassStudentTeamId(courseClassId,studentId,teamId);
    }

    @Override
    public void deleteTeamByTeamId(BigInteger teamId)throws TeamNotFoundException {
        if(teamMapper.getTeamByTeamId(teamId)==null) {
            throw new TeamNotFoundException();
        }
        teamMapper.deleteTeamByTeamId(teamId);
    }

    @Override
    public List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId){
        return teamMapper.getTeamValidApplicationByTeacherId(teacherId);
    }

    @Override
    public void insertTeamValidApplication(TeamValidApplication teamValidApplication,BigInteger teamId,BigInteger teacherId){
        teamMapper.insertTeamValidApplication(teamValidApplication,teamId,teacherId);
    }

    @Override
    public void updateTeamValidApplication(TeamValidApplication teamValidApplication){
        teamMapper.updateTeamValidApplication(teamValidApplication);
    }

    @Override
    public void deleteTeamValidApplicationByTeamValidApplicationId(BigInteger teamValidApplicationId){
        teamMapper.deleteTeamValidApplicationByTeamValidApplicationId(teamValidApplicationId);
    }
}