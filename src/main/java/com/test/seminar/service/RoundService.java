package com.test.seminar.service;

import com.test.seminar.entity.Round;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface RoundService {

    /**
     *
     * @param round
     * @throws RepetitiveRecordException
     */
    void insertRound(Round round) throws RepetitiveRecordException;

    /**
     *
     * @param roundId
     * @throws RoundNotFoundException
     */
    void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     *
     * @param round
     * @throws RoundNotFoundException
     */
    void updateRound(BigInteger round)throws RoundNotFoundException;

    /**
     *
     * @param roundId
     * @return
     * @throws RoundNotFoundException
     */
    Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     *
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(BigInteger courseId);
}
