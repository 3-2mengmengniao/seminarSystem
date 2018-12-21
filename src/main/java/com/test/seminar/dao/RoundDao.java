package com.test.seminar.dao;

import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
import com.test.seminar.entity.SeminarScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;

import java.math.BigInteger;
import java.util.List;

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
     * @param roundScoreId
     * @return
     */
    RoundScore getRoundScoreByRoundId(BigInteger roundScoreId);

    /**
     *
     * @param roundId
     * @param teamId
     * @return
     */
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
    void updateRoundScore(RoundScore roundScore);

    /**
     *
     * @param roundScoreId
     */
    void deleteRoundScoreByRoundScoreId(BigInteger roundScoreId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlId(BigInteger seminarControlId);
}