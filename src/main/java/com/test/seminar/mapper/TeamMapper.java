package com.test.seminar.mapper;

import com.test.seminar.entity.Serial;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.TeamValidApplication;
import com.test.seminar.entity.strategy.StrategyPair;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
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

    List<Team> getTeamByCourseClassId(@Param("courseClassId")BigInteger courseClassId);
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
    void updateTeam(@Param("team")Team team);

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

    void insertCourseClassAndTeamRelation(@Param("courseClassId")BigInteger courseClassId,@Param("teamId")BigInteger teamId);

    void insertTeamAndStudentRelation(@Param("teamId")BigInteger teamId,@Param("studentId")BigInteger studentId);
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

    void deleteCourseClassAndTeamRelation(@Param("teamId")BigInteger teamId,@Param("courseClassId")BigInteger courseClassId);

    void deleteTeamAndStudentRelation(@Param("teamId")BigInteger teamId,@Param("studentId")BigInteger studentId);

    void deleteCourseClassAndTeamRelationByTeamId(@Param("teamId")BigInteger teamId);

    void deleteTeamAndStudentRelationByTeamId(@Param("teamId")BigInteger teamId);

    Team getTeamByMainCourseClassIdAndTeamSerial(@Param("courseClassId")BigInteger courseClassId,@Param("teamSerial")Integer teamSerial);

    Integer getMaxTeamSerialByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    List<Team> getGroupStudentByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 获取strategy下的课程id列表
     * @param strategyId
     * @return
     */
    List<BigInteger> getCourseIdByConflictCourseStrategyId(@Param("strategyId")BigInteger strategyId);

    /**
     * 通过课程ID获取课程的分组策略列表
     * @param courseId
     * @return
     */
    List<TeamStrategy> getTeamStrategyListByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 通过策略ID获取MemberLimitStrategy
     * @param strategyId
     * @return
     */
    MemberLimitStrategy getMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);

    void deleteMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);
    /**
     * 通过策略ID获取CourseMemberLimitStrategy
     * @param strategyId
     * @return
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);

    List<StrategyPair> getStrategyPairByTeamAndStrategyId(@Param("teamAndStrategyId")BigInteger teamAndStrategyId);

    List<StrategyPair> getStrategyPairByTeamOrStrategyId(@Param("teamOrStrategyId")BigInteger teamOrStrategyId);

    /**
     * 获得组队与策略表的Id最大值
     * @return
     */
    BigInteger getMaxTeamAndStrategyId();

    /**
     * 获得组队或表的Id最大值
     * @return
     */
    BigInteger getMaxTeamOrStrategyId();

    /**
     * 获得冲突课程策略表的Id最大值
     * @return
     */
    BigInteger getMaxConflictCourseStrategyId();

    void insertTeamStrategy(@Param("courseId")BigInteger courseId,@Param("strategyName")String strategyName,@Param("strategyId")BigInteger strategyId);

    void insertTeamAndStrategy(@Param("id")BigInteger id, @Param("strategyName")String strategyName,@Param("strategyId")BigInteger strategyId);

    void insertTeamOrStrategy(@Param("id")BigInteger id, @Param("strategyName")String strategyName,@Param("strategyId")BigInteger strategyId);

    void insertConflictCourseStrategy(@Param("id")BigInteger id,@Param("courseId")BigInteger courseId);

    void insertCourseMemberLimitStrategy(@Param("courseMemberLimitStrategy")CourseMemberLimitStrategy courseMemberLimitStrategy);

    void insertMemberLimitStrategy(@Param("memberLimitStrategy")MemberLimitStrategy memberLimitStrategy);

    BigInteger getMaxMemberLimitStrategyId();

    BigInteger getMaxCourseMemberLimitStrategyId();
}
