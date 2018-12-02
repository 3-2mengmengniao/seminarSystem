package com.test.seminar.dao;

import com.test.seminar.entity.Round;
import com.test.seminar.exception.RepetitiveRecordException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/12/1
 */
public interface RoundDao {

    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(Round round);

    /**
     * 删除轮次
     * @param roundId
     */
    void deleteRoundByRoundId(BigInteger roundId);

    /**
     * 更新轮次信息
     * @param round
     */
    void updateRound(BigInteger round);

    /**
     * 通过轮次ID获得轮次信息
     * @param roundId
     * @return
     */
    Round getRoundByRoundId(BigInteger roundId);

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(BigInteger courseId);
}
