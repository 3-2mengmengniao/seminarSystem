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
     * @param teamId team id
     * @return Team
     */
    Team getTeamByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 以学生ID和课程ID获取学生本课程的组队信息
     *
     * @param studentId student id
     * @param courseId course id
     * @return Team
     */
    Team getTeamByStudentIdAndCourseId(@Param("studentId") BigInteger studentId, @Param("courseId") BigInteger courseId);

    /**
     * 查看某课程的所有队伍
     *
     * @param courseId course id
     * @return List<Team>
     */
    List<Team> getTeamByCourseId(@Param("courseId")BigInteger courseId);

    List<Team> getTeamByCourseClassId(@Param("courseClassId")BigInteger courseClassId);
    /**
     * 查看某讨论课的所有队伍
     * @param seminarControlId seminar control id
     * @return List<Team>
     */
    List<Team> getTeamBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *
     * @param teamId team id
     * @return Serial
     */
    Serial getSerialByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 创建新的队伍信息
     *
     * @param team team
     * @param courseClassId course class id
     * @param courseId course id
     */
    void insertTeam(@Param("team")Team team, @Param("courseClassId")BigInteger courseClassId,@Param("courseId")BigInteger courseId);

    /**
     * 更改队伍信息
     *
     * @param team team
     */
    void updateTeam(@Param("team")Team team);

    /**
     * 更新某班级下某学生的队伍
     * @param courseClassId course class id
     * @param studentId student id
     * @param teamId team id
     */
    void updateCourseClassStudentTeamId(@Param("courseClassId")BigInteger courseClassId,@Param("studentId")BigInteger studentId,@Param("teamId")BigInteger teamId);

    /**
     * 通过id删除team
     *
     * @param teamId team id
     */
    void deleteTeamByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 通过教师id获取组队审核申请
     *
     * @param teacherId teacher id
     * @return List<TeamValidApplication>
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(@Param("teacherId")BigInteger teacherId);

    /**
     * 通过组队审核申请id获取小组
     *
     * @param teamValidApplicationId team valid application id
     * @return Team
     */
    Team getTeamByTeamValidApplicationId(@Param("teamValidApplicationId")BigInteger teamValidApplicationId);

    /**
     * 插入组队审核申请
     *
     * @param teamValidApplication team valid applicaiont
     * @param teamId team id
     * @param teacherId teacher id
     */
    void insertTeamValidApplication(@Param("teamValidApplication") TeamValidApplication teamValidApplication, @Param("teamId")BigInteger teamId, @Param("teacherId")BigInteger teacherId);

    void insertCourseClassAndTeamRelation(@Param("courseClassId")BigInteger courseClassId,@Param("teamId")BigInteger teamId);

    void insertTeamAndStudentRelation(@Param("teamId")BigInteger teamId,@Param("studentId")BigInteger studentId);
    /**
     *更新组队审核申请
     *
     * @param teamValidApplication team valid application
     */
    void updateTeamValidApplication(@Param("teamValidApplication")TeamValidApplication teamValidApplication);

    TeamValidApplication getTeamValidApplicationByApplicationId(@Param("applicationId")BigInteger applicationId);
    /**
     * 通过id删除组队审核申请
     *
     * @param teamValidApplicationId team valid application id
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
     * @param strategyId strategy id
     * @return List<BigInteger>
     */
    List<BigInteger> getCourseIdByConflictCourseStrategyId(@Param("strategyId")BigInteger strategyId);

    /**
     * 通过课程ID获取课程的分组策略列表
     * @param courseId course id
     * @return List<TeamStrategy>
     */
    List<TeamStrategy> getTeamStrategyListByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 通过策略ID获取MemberLimitStrategy
     * @param strategyId strategy id
     * @return MemberLimitStrategy
     */
    MemberLimitStrategy getMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);

    void deleteMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);
    /**
     * 通过策略ID获取CourseMemberLimitStrategy
     * @param strategyId strategy id
     * @return CourseMemberLimitStrategy
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);

    List<StrategyPair> getStrategyPairByTeamAndStrategyId(@Param("teamAndStrategyId")BigInteger teamAndStrategyId);

    List<StrategyPair> getStrategyPairByTeamOrStrategyId(@Param("teamOrStrategyId")BigInteger teamOrStrategyId);

    /**
     *
     * 获得组队与策略表的Id最大值
     * @return BigInteger
     */
    BigInteger getMaxTeamAndStrategyId();

    /**
     * 获得组队或表的Id最大值
     * @return BigInteger
     */
    BigInteger getMaxTeamOrStrategyId();

    /**
     * 获得冲突课程策略表的Id最大值
     * @return BigInteger
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

    List<ConflictCourseStrategy> getConflictCourseStrategyByStrategyId(@Param("strategyId")BigInteger strategyId);

    void updateMemberLimitStrategy(@Param("memberLimitStrategy") MemberLimitStrategy memberLimitStrategy);
}
