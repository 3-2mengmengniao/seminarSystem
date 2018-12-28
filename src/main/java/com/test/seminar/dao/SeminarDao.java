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
     * @param seminarInfoId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarControlId(BigInteger seminarControlId);

    /**
     * 获取某讨论课某班级下对应的讨论课控制器
     * @param classId
     * @param seminarInfoId
     * @return
     */
    SeminarControl getSeminarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId)throws SeminarControlNotFoundException;

    /**
     * 获取某轮次下的所有讨论课信息
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     *
     * @param seminarName
     * @param courseId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarNameAndCourseId(String seminarName,BigInteger courseId);

    /**
     * 通过roundID获取round对应的讨论课信息
     * @param seminarControlId
     * @return
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return
     */
    void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId,BigInteger courseId)throws RepetitiveRecordException;

    /**
     *
     * @param seminarControl
     */
    void insertSeminarControl(SeminarControl seminarControl,BigInteger classId,BigInteger seminarInfoId);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws SeminarInfoNotFoundException;

    /**
     *
     * @param seminarControl
     */
    void updateSeminarControl(SeminarControl seminarControl);

    /**
     * 删除讨论课信息
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;



    /**
     *
     * @param seminarControlId
     */
    void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @param teamId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);

    /**
     *
     * @param teamId
     * @return
     */
    List<SeminarScore> getSeminarScoreByTeamId(BigInteger teamId);

    /**
     *
     * @param seminarScore
     */
    void insertSeminarScore(SeminarScore seminarScore,BigInteger seminarControlId,BigInteger teamId);

    void updateSeminarScore(SeminarScore seminarScore,BigInteger seminarControlId,BigInteger teamId);

    /**
     *
     * @param seminarControlId
     * @param teamId
     */
    void deleteSeminarScoreBySeminarScoreId(BigInteger seminarControlId,BigInteger teamId);

    /**
     *
     * @param roundId
     */
    void deleteSeminarControlByRoundId(BigInteger roundId);

    /**
     *
     * @param roundId
     */
    void deleteSeminarInfoByRoundId(BigInteger roundId);
}