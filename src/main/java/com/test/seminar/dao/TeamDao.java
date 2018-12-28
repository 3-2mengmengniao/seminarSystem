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
     * @param teamId
     * @return
     */
    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

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

    /**
     * 查看某讨论课的所有队伍
     * @param seminarControlId
     * @return
     */
    List<Team> getTeamBySeminarControlId(BigInteger seminarControlId);

    Serial getSerialByTeamId(BigInteger teamId);

    /**
     * 创建新的队伍信息
     * @param team
     * @return
     */
    void insertTeam(Team team,BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException;

    void insertCourseClassAndTeamRelation(BigInteger courseClassId,BigInteger teamId);
    /**
     * 更改队伍信息
     * @param team
     * @return
     */
    void updateTeam(Team team)throws TeamNotFoundException;

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

    /**
     * 根据老师ID获取老师对应的所有课程的学生发送的申请
     * @param teacherId
     * @return
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId);

    /**
     *
     * @param teamValidApplication
     * @param teamId
     * @param teacherId
     */
    void insertTeamValidApplication(TeamValidApplication teamValidApplication,BigInteger teamId,BigInteger teacherId);

    /**
     *
     * @param teamValidApplication
     */
    void updateTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     *
     * @param teamValidApplicationId
     */
    void deleteTeamValidApplicationByTeamValidApplicationId(BigInteger teamValidApplicationId);

    void deleteCourseClassAndTeamRelationByTeamId(BigInteger teamId);

    Team getTeamByMainCourseClassIdAndTeamSerial(BigInteger courseClassId,Integer teamSerial);

    void insertTeamAndStudentRelation(BigInteger teamId,BigInteger studentId);

    void deleteCourseClassAndTeamRelation(BigInteger teamId,BigInteger courseClassId);

    void deleteTeamAndStudentRelation(BigInteger teamId,BigInteger studentId);

    void deleteTeamAndStudentRelationByTeamId(BigInteger teamId);

    Integer getMaxTeamSerialByCourseClassId(BigInteger courseClassId);

    List<Team> getGroupStudentByCourseId(BigInteger courseId);

    void insetTeamStrategy(BigInteger courseId,List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse, Integer choose);

    /**
     * 通过课程ID获取课程的分组策略列表
     * @param courseId
     * @return
     */
    List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId)throws StrategyNotFoundException;

    /**
     * 通过课程ID删除课程的分组策略列表
     * @param courseId
     * @return
     */
    void deleteTeamStrategyListByCourseId(BigInteger courseId)throws StrategyNotFoundException;

    /**
     * 通过策略ID获取队伍人数限制
     * @param strategyId
     * @return
     */
    MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略ID删除队伍人数限制
     * @param strategyId
     */
    void deleteMemberLimitStrategyByStrategyId(BigInteger strategyId);

    /**
     * 通过策略ID获取队伍选课人数限制
     * @param strategyId
     * @return
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 删除课程队伍选课人数限制
     * @param strategyId
     * @throws StrategyNotFoundException
     */
    void deleteCourseMemberLimitStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;
    /**
     * 通过策略ID获取冲突课程限制
     * @param strategyId
     * @return
     */
    ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略ID删除冲突课程限制
     * @param strategyId
     * @return
     */
    void deleteConflictCourseStrategyByStrategyId(BigInteger strategyId)throws StrategyNotFoundException;

    /**
     * 通过策略类名，策略id，验证某队伍（teamId）是否符合简单策略
     * @param team,strategyId,strategyName
     * @return
     */
    Boolean validSimpleStrategyOnTeam(Team team, BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    /**
     * 通过策略类名，策略id，验证某队伍（teamId）是否符合复合策略
     * @param team,strategyId,strategyName
     * @return
     */
    Boolean validCompositStrategyOnTeam(Team team, BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    /**
     * 通过策略id获取CompositStrategy
     * @param strategyId
     * @return
     */
    CompositStrategy getCompositStrategyByStrategyId(BigInteger strategyId, String strategyName)throws StrategyNotFoundException;

    void getCompositStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String strategyName,HashMap result);

    void getSimpleStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String  strategyName,HashMap result);
}