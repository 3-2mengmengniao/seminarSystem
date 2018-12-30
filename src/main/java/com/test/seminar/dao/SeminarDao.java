package com.test.seminar.dao;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.entity.SeminarScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface SeminarDao {

    /**
     * 通过ID获取讨论课信息
     * @param seminarInfoId seminar info id
     * @return SeminarInfo
     * @throws SeminarInfoNotFoundException seminar info not found
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     *通过班级讨论课id获取讨论课信息
     *
     * @param seminarControlId seminar control id
     * @return SeminarInfo
     */
    SeminarInfo getSeminarInfoBySeminarControlId(BigInteger seminarControlId);

    /**
     * 获取某讨论课某班级下对应的讨论课控制器
     * @param classId class id
     * @param seminarInfoId seminar info id
     * @return seminarControl
     * @throws SeminarControlNotFoundException seminar control not found
     */
    SeminarControl getSeminarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId)throws SeminarControlNotFoundException;

    /**
     * 获取某轮次下的所有讨论课信息
     * @param roundId round id
     * @return List<SeminarInfo>
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     * 通过课程和讨论课名获取讨论课信息
     *
     * @param seminarName seminar name
     * @param courseId course id
     * @return SeminarInfo
     */
    SeminarInfo getSeminarInfoBySeminarNameAndCourseId(String seminarName,BigInteger courseId);

    /**
     * 通过roundID获取round对应的讨论课信息
     * @param seminarControlId SeminarControl id
     * @return SeminarControl
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 创建新的讨论课信息
     *
     * @param seminarInfo seminar info
     * @param roundId round id
     * @param courseId course id
     * @throws RepetitiveRecordException repetitve record found
     */
    void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId,BigInteger courseId)throws RepetitiveRecordException;

    /**
     * 插入班级讨论课
     *
     * @param seminarControl seminar control
     * @param classId class id
     * @param seminarInfoId seminar info id
     */
    void insertSeminarControl(SeminarControl seminarControl,BigInteger classId,BigInteger seminarInfoId);

    /**
     * 更改讨论课信息
     * @param seminarInfo seminar info
     * @param roundId round id
     * @throws SeminarInfoNotFoundException seminar not found
     */
    void updateSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws SeminarInfoNotFoundException;

    /**
     * 更新班级讨论课
     *
     * @param seminarControl seminar control
     */
    void updateSeminarControl(SeminarControl seminarControl);

    /**
     * 删除讨论课信息
     * @param seminarInfoId seminar info id
     * @throws SeminarInfoNotFoundException seminar info not found
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     * 通过id删除班级讨论课
     *
     * @param seminarControlId seminar control id
     */
    void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 通过班级讨论课获取讨论课分数
     *
     * @param seminarControlId seminar control id
     * @return List<SeminarScore>
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId);

    /**
     * 通过小组id和班级讨论课获取讨论课成绩
     *
     * @param seminarControlId seminar control id
     * @param teamId team id
     * @return SeminarScore
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);

    /**
     * 通过小组id获取讨论课成绩
     *
     * @param teamId team id
     * @return List<SeminarScore>
     */
    List<SeminarScore> getSeminarScoreByTeamId(BigInteger teamId);

    /**
     * 插入讨论课成绩
     *
     * @param seminarScore seminar score
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void insertSeminarScore(SeminarScore seminarScore,BigInteger seminarControlId,BigInteger teamId);

    /**
     * 更新讨论课成绩
     *
     * @param seminarScore seminar score
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void updateSeminarScore(SeminarScore seminarScore,BigInteger seminarControlId,BigInteger teamId);

    /**
     * 通过id删除讨论课成绩
     *
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void deleteSeminarScoreBySeminarScoreId(BigInteger seminarControlId,BigInteger teamId);

    /**
     * 通过轮次id删除班级讨论课
     *
     * @param roundId round id
     */
    void deleteSeminarControlByRoundId(BigInteger roundId);

    /**
     * 通过轮次id删除讨论课信息
     *
     * @param roundId round id
     */
    void deleteSeminarInfoByRoundId(BigInteger roundId);
}