package com.test.seminar.dao;

import com.test.seminar.entity.Serial;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.TeamValidApplication;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.exception.TeamNotFoundException;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface TeamDao {
    /**
     * 通过ID获取队伍信息
     * @param teamId team id
     * @return Team
     * @throws TeamNotFoundException team not found
     */
    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

    /**
     * 以学生ID和课程ID获取学生本课程的组队信息
     * @param studentId student id
     * @param courseId course id
     * @return Team
     */
    Team getTeamByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId);

    /**
     * 查看某课程的所有队伍
     * @param courseId course id
     * @return List<Team>
     */
    List<Team> getTeamByCourseId(BigInteger courseId);

    /**
     * 查看某讨论课的所有队伍
     * @param seminarControlId seminar control id
     * @return List<Team>
     */
    List<Team> getTeamBySeminarControlId(BigInteger seminarControlId);

    Serial getSerialByTeamId(BigInteger teamId);

    /**
     * 创建新的队伍信息
     * @param team team
     * @param courseId course id
     * @param courseClassId course class id
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertTeam(Team team,BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException;

    void insertCourseClassAndTeamRelation(BigInteger courseClassId,BigInteger teamId);
    /**
     * 更改队伍信息
     * @param team team
     * @throws TeamNotFoundException team not found
     */
    void updateTeam(Team team)throws TeamNotFoundException;

    /**
     * 更新某班级下某学生的队伍
     * @param courseClassId course class id
     * @param studentId student id
     * @param teamId team id
     */
    void updateCourseClassStudentTeamId(BigInteger courseClassId,BigInteger studentId,BigInteger teamId);


    /**
     * 通过小组id删除小组
     *
     * @param teamId team id
     * @throws TeamNotFoundException team not found
     */
    void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException;

    /**
     * 根据老师ID获取老师对应的所有课程的学生发送的申请
     * @param teacherId teacher id
     * @return List<TeamValidApplication>
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId);

    /**
     * 插入组队验证申请
     *
     * @param teamValidApplication team valid application
     * @param teamId team id
     * @param teacherId teacher id
     */
    void insertTeamValidApplication(TeamValidApplication teamValidApplication,BigInteger teamId,BigInteger teacherId);

    /**
     * 通过id获取队伍验证申请
     * @param applicationId application id
     * @return TeamValidApplication
     */
    TeamValidApplication getTeamValidApplicationByApplicationId(BigInteger applicationId);
    /**
     * 更新组队审核申请
     *
     * @param teamValidApplication team valid application
     */
    void updateTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     * 通过id删除组队审核申请
     *
     * @param teamValidApplicationId team valid application id
     */
    void deleteTeamValidApplicationByTeamValidApplicationId(BigInteger teamValidApplicationId);

    /**
     * 删除课程和队伍的联系
     * @param teamId
     */
    void deleteCourseClassAndTeamRelationByTeamId(BigInteger teamId);

    /**
     * 获得主课程的第teamSerial个队伍
     * @param courseClassId
     * @param teamSerial
     * @return
     */
    Team getTeamByMainCourseClassIdAndTeamSerial(BigInteger courseClassId,Integer teamSerial);

    /**
     * 创建队伍和学生的关系
     * @param teamId
     * @param studentId
     */
    void insertTeamAndStudentRelation(BigInteger teamId,BigInteger studentId);

    /**
     * 删除课程和队伍的联系
     * @param teamId
     * @param courseClassId
     */
    void deleteCourseClassAndTeamRelation(BigInteger teamId,BigInteger courseClassId);

    /**
     * 删除队伍和学生的关系
     * @param teamId
     * @param studentId
     */
    void deleteTeamAndStudentRelation(BigInteger teamId,BigInteger studentId);

    /**
     * 删除某个队伍和下属学生的关系
     * @param teamId
     */
    void deleteTeamAndStudentRelationByTeamId(BigInteger teamId);

    /**
     * 获得某课程的队伍序列号的最大值
     * @param courseClassId
     * @return
     */
    Integer getMaxTeamSerialByCourseClassId(BigInteger courseClassId);

    /**
     * 获得某课程下的组队列表
     * @param courseId
     * @return
     */
    List<Team> getGroupStudentByCourseId(BigInteger courseId);

    /**
     * 创建分组策略
     * @param courseId
     * @param conflictCourseStrategyArrayList
     * @param courseMemberLimitStrategyList
     * @param thisCourse
     * @param choose
     */
    void insetTeamStrategy(BigInteger courseId,List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse, Integer choose);

    /**
     * 通过课程ID获取课程的分组策略列表
     * @param courseId course id
     * @return List<TeamStrategy>
     *@throws StrategyNotFoundException strategy not found
     */
    List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId)throws StrategyNotFoundException;

    /**
     * 通过课程ID删除课程的分组策略列表
     * @param courseId course id
     * @throws StrategyNotFoundException strategy not found
     */
    void deleteTeamStrategyListByCourseId(BigInteger courseId)throws StrategyNotFoundException;

    /**
     * 通过策略ID获取队伍人数限制
     * @param strategyId strategy id
     * @return MemberLimitStrategy
     * @throws StrategyNotFoundException strategy not found
     */
    MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略ID删除队伍人数限制
     * @param strategyId strategy id
     */
    void deleteMemberLimitStrategyByStrategyId(BigInteger strategyId);

    /**
     * 通过策略ID获取队伍选课人数限制
     * @param strategyId strategy id
     * @return CourseMemberLimitStrategy
     * @throws StrategyNotFoundException strategy not found
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 删除课程队伍选课人数限制
     * @param strategyId strategy id
     * @throws StrategyNotFoundException strategy not found
     */
    void deleteCourseMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;
    /**
     * 通过策略ID获取冲突课程限制
     * @param strategyId strategy id
     * @return ConflictCourseStrategy
     * @throws StrategyNotFoundException strategy not found
     */
    ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略ID删除冲突课程限制
     * @param strategyId strategy id
     * @throws StrategyNotFoundException strategy not found
     */
    void deleteConflictCourseStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略类名，策略id，验证某队伍（teamId）是否符合简单策略
     * @param team team
     * @param strategyId strategy id
     * @param strategyName strategy name
     * @return Boolean
     * @throws StrategyNotFoundException strategy not found
     */
    Boolean validSimpleStrategyOnTeam(Team team, BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    /**
     * 通过策略类名，策略id，验证某队伍（teamId）是否符合复合策略
     * @param team team
     * @param strategyId strategy id
     * @param strategyName strategy name
     * @return Boolean
     * @throws StrategyNotFoundException strategy not found
     */
    Boolean validCompositStrategyOnTeam(Team team, BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    /**
     * 通过策略id获取CompositStrategy
     * @param strategyId strategy id
     * @return CompositStrategy
     */
    CompositStrategy getCompositStrategyByStrategyId(BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    /**
     * 获得分则的复杂规则（OR AND）
     * @param courseId
     * @param strategyId
     * @param strategyName
     * @param result
     */
    void getCompositStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String strategyName,HashMap result);

    /**
     * 获得原子策略
     * @param courseId
     * @param strategyId
     * @param strategyName
     * @param result
     */
    void getSimpleStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String  strategyName,HashMap result);
}