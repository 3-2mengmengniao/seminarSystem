package com.test.seminar.dao;

import com.test.seminar.entity.Team;

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
    Team getTeamByTeamId(BigInteger teamId);

    /**
     * 创建新的队伍信息
     * @param team
     * @return 新建队伍信息的ID
     */
    void insertTeam(Team team);

    /**
     * 根据队伍信息ID更改队伍信息
     * @param teamId
     * @param team
     * @return
     */
    void updateTeamByTeamId(BigInteger teamId, Team team);

    /**
     *
     * @param teamId
     * @return
     */
    void deleteTeamByTeamId(BigInteger teamId);

    /**
     * 以学生ID和课程ID获取学生本课程的组队信息
     * @param studentId
     * @param courseId
     * @return
     */
    Team getTeamByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId);

    /**
     * 查看某课程的所有队伍
     * @param courseId
     * @return
     */
    List<Team> getTeamByCourseId(BigInteger courseId);


}
