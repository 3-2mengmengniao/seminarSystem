package com.test.seminar.dao;

import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
import com.test.seminar.entity.SeminarScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author cxh
 * @date 2018/12/1
 */
public interface RoundDao {
    /**
     * 通过轮次ID获得轮次信息
     * @param roundId
     * @return
     */
    Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(BigInteger courseId);

    /**
     *
     * @param courseId
     * @param teamId
     * @return
     */
    List<Round> getRoundByCourseId(BigInteger courseId,BigInteger teamId);
    /**
     *
     * @param seminarInfoId
     * @return
     */
    int getRoundSerialBySeminarInfoId(BigInteger seminarInfoId);

    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(Round round,BigInteger courseId)throws RepetitiveRecordException;

    /**
     * 更新轮次信息
     * @param round
     */
    void updateRound(Round round)throws RoundNotFoundException;

    /**
     * 删除轮次
     * @param roundId
     */
    void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     *
     * @param roundId
     * @return
     */
    List<RoundScore> getRoundScoreByRoundId(BigInteger roundId);

    RoundScore getRoundScoreByRoundIdAndTeamId(BigInteger roundId,BigInteger teamId);


    /**
     *
     * @param roundScore
     */
    void insertRoundScore(RoundScore roundScore);

    /**
     *
     * @param roundScore
     */
    void updateRoundScore(RoundScore roundScore,BigInteger roundId,BigInteger teamId);

    /**
     *
     * @param roundId
     */
    void deleteRoundScoreByRoundId(BigInteger roundId);

    /**
     *
     * @param courseId
     * @return
     */
    Integer getMaxRoundSerialByCourseId(BigInteger courseId);

    /**
     *
     * @param courseId
     * @param roundSerial
     * @return
     */
    Round getRoundByCourseIdAndRoundSerial(BigInteger courseId, int roundSerial);

    List<RoundScore> getRoundScoreByTeamId(BigInteger teamId);

    Integer getEnrollNumBycourseClassIdAndRoundId(BigInteger courseClassId,BigInteger roundId);

    void updateEnrollNum(BigInteger courseClassId,BigInteger roundId);

    BigInteger getRoundIdBySeminarControlId(BigInteger seminarControlId);

    void updateCourseClassRound(BigInteger roundId, Map<BigInteger,Integer> courseClassMap);
}