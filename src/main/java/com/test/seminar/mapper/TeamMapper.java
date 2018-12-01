package com.test.seminar.mapper;

import com.test.seminar.entity.Team;
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
    Team getTeamByTeamId(BigInteger teamId);

    /**
     * 创建新的队伍信息
     *
     * @param team
     * @return
     */
    void insertTeam(Team team);

    /**
     * 更改队伍信息
     *
     * @param team
     * @return
     */
    void updateTeamByTeamId(Team team);

    /**
     * @param teamId
     * @return
     */
    void deleteTeamByTeamId(BigInteger teamId);

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
    List<Team> getTeamByCourseId(BigInteger courseId);

}
