package com.test.seminar.dao;

import com.test.seminar.entity.Team;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface TeamDao {
    /**
     * 通过ID获取队伍信息
     * @param teamId
     * @return
     */
    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

    /**
     * 创建新的队伍信息
     * @param team
     * @return
     */
    void insertTeam(Team team,BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException;

    /**
     * 更改队伍信息
     * @param team
     * @return
     */
    void updateTeamByTeamId(Team team)throws TeamNotFoundException;

    /**
     * 更新某班级下某学生的队伍
     * @param courseClassId
     * @param studentId
     * @param teamId
     * @return
     */
    void updateCourseClassStudentTeamId(BigInteger courseClassId,BigInteger studentId,BigInteger teamId);


    /**
     *
     * @param teamId
     * @return
     */
    void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException;
}