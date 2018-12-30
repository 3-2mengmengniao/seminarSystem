package com.test.seminar.service;

import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface RoundService {

    /**
     * 创建新轮次
     * @param round round
     * @param courseId course id
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertRound(Round round, BigInteger courseId) throws RepetitiveRecordException;

    /**
     * 删除轮次
     * @param roundId round id
     * @throws RoundNotFoundException round not found
     */
    void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 更新轮次信息
     * @param round round
     * @throws RoundNotFoundException round not found
     */
    void updateRound(Round round)throws RoundNotFoundException;

    /**
     * 通过轮次ID获得轮次信息
     * @param roundId round id
     * @return round
     * @throws RoundNotFoundException round not found
     */
    Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId course id
     * @return List<round>
     */
    List<Round> getRoundByCourseId(BigInteger courseId);

    /**
     * 得到包含筛选过队伍的RoundScore的轮次信息
     * @param courseId course id
     * @param teamId team id
     * @return List<round>
     */
    List<Round> getRoundByCourseId(BigInteger courseId,BigInteger teamId);

    /**
     * 更新班级轮次
     * @param roundId round id
     * @param courseClassMap course class map
     */
    void updateCourseClassRound(BigInteger roundId, Map<BigInteger,Integer> courseClassMap);
}
