package com.test.seminar.service;

import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface TeamService {

    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

    void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException;

    void updateTeamByTeamId(Team team) throws TeamNotFoundException;

    void insertTeam(Team team,BigInteger courseClassId) throws RepetitiveRecordException;

}
