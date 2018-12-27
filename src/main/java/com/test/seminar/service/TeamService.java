package com.test.seminar.service;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import javafx.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

public interface TeamService {

    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

    void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException;

    void updateTeam(Team team) throws TeamNotFoundException;

    void insertTeam(Team team,List<BigInteger> memberIdList) throws RepetitiveRecordException;

    Team getTeamByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId)throws TeamNotFoundException;

    List<Team> getTeamByCourseId(BigInteger courseId);

    List<Team> getTeamBySeminarControlId(BigInteger seminarControlId);

    Pair<List<Team>,List<Student>> getTeam(BigInteger courseId);

    void addTeamMember(BigInteger teamId,BigInteger studentId);

    void deleteTeamMember(BigInteger teamId,BigInteger studentId);

    /**
     * 验证队伍是否合法
     * @param team
     * @throws TeamNotFoundException
     * @return
     */
    Boolean isTeamValid(Team team)throws TeamNotFoundException;
}
