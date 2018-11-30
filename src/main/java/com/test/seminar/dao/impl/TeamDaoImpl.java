package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Team;
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

    @Override
    public Team getTeamByTeamId(BigInteger teamId) {
        return teamMapper.getTeamByTeamId(teamId);
    }

    @Override
    public void insertTeam(Team team) {
        teamMapper.insertTeam(team);
    }

    @Override
    public void updateTeamByTeamId(Team team) {
        teamMapper.updateTeamByTeamId(team);
    }

    @Override
    public void deleteTeamByTeamId(BigInteger teamId) {
        teamMapper.deleteTeamByTeamId(teamId);
    }

    @Override
    public Team getTeamByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId) {
        return teamMapper.getTeamByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Team> getTeamByCourseId(BigInteger courseId) {
        return teamMapper.getTeamByCourseId(courseId);
    }
}
