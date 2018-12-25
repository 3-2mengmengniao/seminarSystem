package com.test.seminar.mapper;

import com.test.seminar.entity.Serial;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.TeamValidApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Mapper
@Component
public interface TeamMapper {
    /**
     * 通过ID获取队伍信息
     *
     * @param teamId
     * @return
     */
    Team getTeamByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 以学生ID和课程ID获取学生本课程的组队信息
     *
     * @param studentId
     * @param courseId
     * @return
     */
    Team getTeamByStudentIdAndCourseId(@Param("studentId") BigInteger studentId, @Param("courseId") BigInteger courseId);

    /**
     * 查看某课程的所有队伍
     *
     * @param courseId
     * @return
     */
    List<Team> getTeamByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 查看某讨论课的所有队伍
     * @param seminarControlId
     * @return
     */
    List<Team> getTeamBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *
     * @param teamId
     * @return
     */
    Serial getSerialByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 创建新的队伍信息
     *
     * @param team
     * @return
     */
    void insertTeam(@Param("team")Team team, @Param("courseClassId")BigInteger courseClassId,@Param("courseId")BigInteger courseId);

    /**
     * 更改队伍信息
     *
     * @param team
     * @return
     */
    void updateTeamByTeamId(@Param("team")Team team);

    /**
     * 更新某班级下某学生的队伍
     * @param courseClassId
     * @param studentId
     * @param teamId
     * @return
     */
    void updateCourseClassStudentTeamId(@Param("courseClassId")BigInteger courseClassId,@Param("studentId")BigInteger studentId,@Param("teamId")BigInteger teamId);

    /**
     * @param teamId
     * @return
     */
    void deleteTeamByTeamId(@Param("teamId")BigInteger teamId);

    /**
     *
     * @param teacherId
     * @return
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(@Param("teacherId")BigInteger teacherId);

    /**
     *
     * @param teamValidApplicationId
     * @return
     */
    Team getTeamByTeamValidApplicationId(@Param("teamValidApplicationId")BigInteger teamValidApplicationId);

    /**
     *
     * @param teamValidApplication
     * @param teamId
     * @param teacherId
     */
    void insertTeamValidApplication(@Param("teamValidApplication") TeamValidApplication teamValidApplication, @Param("teamId")BigInteger teamId, @Param("teacherId")BigInteger teacherId);

    /**
     *
     * @param teamValidApplication
     */
    void updateTeamValidApplication(@Param("teamValidApplication")TeamValidApplication teamValidApplication);

    /**
     *
     * @param teamValidApplicationId
     */
    void deleteTeamValidApplicationByTeamValidApplicationId(@Param("teamValidApplicationId")BigInteger teamValidApplicationId);
}
