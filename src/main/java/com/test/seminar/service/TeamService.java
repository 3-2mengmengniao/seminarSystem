package com.test.seminar.service;

import com.test.seminar.entity.*;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import javafx.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */

public interface TeamService {

    /**
     * 根据队伍ID获得队伍
     * @param teamId
     * @return
     * @throws TeamNotFoundException
     */
    Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException;

    /**
     * 根据队伍Ids删除队伍
     * @param teamId
     * @throws TeamNotFoundException
     */
    void deleteTeamByTeamId(BigInteger teamId) throws TeamNotFoundException;

    /**
     * 更新队伍信息
     * @param team
     * @throws TeamNotFoundException
     */
    void updateTeam(Team team) throws TeamNotFoundException;

    /**
     * 创建队伍
     * @param team
     * @param memberIdList
     * @throws RepetitiveRecordException
     */
    void insertTeam(Team team,List<BigInteger> memberIdList) throws RepetitiveRecordException;

    /**
     * 通过学生Id和课程Id获得队伍
     * @param studentId
     * @param courseId
     * @return
     * @throws TeamNotFoundException
     */
    Team getTeamByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId)throws TeamNotFoundException;

    /**
     * 获得某课程下的所有队伍
     * @param courseId
     * @return
     */
    List<Team> getTeamByCourseId(BigInteger courseId);

    /**
     * 获得某讨论课下的所有队伍
     * @param seminarControlId
     * @return
     */
    List<Team> getTeamBySeminarControlId(BigInteger seminarControlId);

    /**
     * 获得分组信息页的信息
     * @param courseId
     * @return 一是队伍信息，二是未组队学生
     */
    Pair<List<Team>,List<Student>> getTeam(BigInteger courseId);

    /**
     * 添加组员
     * @param teamId
     * @param studentIdList
     */
    void addTeamMember(BigInteger teamId,List<BigInteger> studentIdList);

    /**
     * 删除组员
     * @param teamId
     * @param studentId
     */
    void deleteTeamMember(BigInteger teamId,BigInteger studentId);

    /**
     * 验证队伍是否合法
     * @param team team
     * @throws TeamNotFoundException team not found exception
     * @return Boolean
     */
    Boolean isTeamValid(Team team)throws TeamNotFoundException;

    /**
     * 创建共享组队申请
     * @param teamValidApplication
     * @param teamId
     * @param teacherId
     */
    void insertTeamValidApplication(TeamValidApplication teamValidApplication, BigInteger teamId, BigInteger teacherId);

    /**
     * 获得分组申请列表
     * @param teacherId
     * @return
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId);

    /**
     * 更新队伍分享申请
     * @param teamValidApplication
     */
    void updateTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     * 获得某课程的所有规则
     * @param courseId course id
     * @return 元素依次是List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse, List<Integer> chooseList
     */
    HashMap getStrategyByCourseId(BigInteger courseId);

    /**
     * 教师处理共享分组请求
     * @param shareTeamApplication share team application
     */
    void updateShareTeamApplication(ShareTeamApplication shareTeamApplication);

    /**
     * 取消分组共享
     * @param subCourse sub course
     */
    void cancelTeamShare(Course subCourse);

    /**
     *
     * @param applicationId application id
     * @return TeamValidApplication
     */
    TeamValidApplication getTeamValidApplicationByApplicationId(BigInteger applicationId);
}
