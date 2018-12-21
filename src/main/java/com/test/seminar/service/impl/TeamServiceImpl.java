package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.CourseClass;
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
    @Autowired
    private CourseClassDao courseClassDao;
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
    public void insertTeam(Team team,BigInteger courseClassId) throws RepetitiveRecordException {
        CourseClass courseClass = courseClassDao.getCourseClassByCourseClassId(courseClassId);
        teamDao.insertTeam(team,courseClassId,courseClass.getCourse().getId());
    }
}
