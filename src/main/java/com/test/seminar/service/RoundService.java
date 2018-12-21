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
     * 创建新轮次
     * @param round
     * @throws RepetitiveRecordException
     */
    void insertRound(Round round, BigInteger courseId) throws RepetitiveRecordException;

    /**
     * 删除轮次
     * @param roundId
     * @throws RoundNotFoundException
     */
    void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 更新轮次信息
     * @param round
     * @throws RoundNotFoundException
     */
    void updateRound(Round round)throws RoundNotFoundException;

    /**
     * 通过轮次ID获得轮次信息
     * @param roundId
     * @return
     * @throws RoundNotFoundException
     */
    Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;
}
