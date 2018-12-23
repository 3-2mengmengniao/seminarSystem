package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
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

    private void setTeamLeaderAndUpdateMemberList(Team team){
        for(int i=0;i<team.getMemberList().size();i++){
            if(team.getMemberList().get(i).getId().equals(team.getLeader().getId())) {
                team.getMemberList().remove(i);
                break;
            }
        }
    }
    @Override
    public Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException {
        Team team=teamMapper.getTeamByTeamId(teamId);
        if(team==null) {
            throw new TeamNotFoundException();
        }
        setTeamLeaderAndUpdateMemberList(team);
        return team;
    }

    @Override
    public List<Team> getTeamByCourseId(BigInteger courseId) {
        List<Team> teamList=teamMapper.getTeamByCourseId(courseId);
        for(int i=0;i<teamList.size();i++){
            setTeamLeaderAndUpdateMemberList(teamList.get(i));
        }
       return teamList;
    }

    @Override
    public List<Team> getTeamBySeminarControlId(BigInteger seminarControlId) {
        List<Team> teamList=teamMapper.getTeamBySeminarControlId(seminarControlId);
        for(int i=0;i<teamList.size();i++){
            setTeamLeaderAndUpdateMemberList(teamList.get(i));
        }
        return teamList;
    }

    @Override
    public Team getTeamByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId) throws TeamNotFoundException {
        Team team=teamMapper.getTeamByStudentIdAndCourseId(studentId,courseId);
        if(team==null) {
            throw new TeamNotFoundException();
        }
        setTeamLeaderAndUpdateMemberList(team);
        return team;
    }

    @Override
    public void insertTeam(Team team, BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException {
        teamMapper.insertTeam(team,courseClassId,courseId);
    }

    @Override
    public void updateTeamByTeamId(Team team)throws TeamNotFoundException {
        if(teamMapper.getTeamByTeamId(team.getId())==null) {
            throw new TeamNotFoundException();
        }
        teamMapper.updateTeamByTeamId(team);
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
}