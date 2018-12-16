package com.test.seminar.service.impl;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;
    @Override
    public Team getTeamByTeamId(BigInteger teamId) throws TeamNotFoundException {
        return teamDao.getTeamByTeamId(teamId);
    }

    @Override
    public void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException {
        teamDao.deleteTeamByTeamId(teamId);
    }

    @Override
    public void updateTeamByTeamId(Team team) throws TeamNotFoundException {
        teamDao.updateTeamByTeamId(team);
    }

    @Override
    public void insertTeam(Team team) throws RepetitiveRecordException {
        teamDao.insertTeam(team);
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
}
