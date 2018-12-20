package com.test.seminar.dao;

import com.test.seminar.entity.Round;
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
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(BigInteger courseId);

    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(Round round)throws RepetitiveRecordException;

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
}