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
     * @param roundId round id
     * @return round
     * @throws RoundNotFoundException round not found
     */
    Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId course id
     * @return list<round>
     */
    List<Round> getRoundByCourseId(BigInteger courseId);

    /**
     * 通过课程id获取所有轮次
     *
     * @param courseId course id
     * @param teamId team id
     * @return list<round>
     */
    List<Round> getRoundByCourseId(BigInteger courseId,BigInteger teamId);
    /**
     * 通过讨论课信息获取轮次顺序
     *
     * @param seminarInfoId seminar info id
     * @return int
     */
    int getRoundSerialBySeminarInfoId(BigInteger seminarInfoId);

    /**
     * 创建新轮次
     *
     * @param round round
     * @param courseId course id
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertRound(Round round,BigInteger courseId)throws RepetitiveRecordException;

    /**
     * 更新轮次信息
     * @param round round
     * @throws RoundNotFoundException round not found
     */
    void updateRound(Round round)throws RoundNotFoundException;

    /**
     * 删除轮次
     * @param roundId round id
     * @throws RoundNotFoundException round not found
     */
    void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException;

    /**
     * 通过轮次获取每轮分数
     *
     * @param roundId  round id
     * @return List<RoundScore>
     */
    List<RoundScore> getRoundScoreByRoundId(BigInteger roundId);

    /**
     * 通过轮次和小组获取本轮分数
     *
     * @param roundId round id
     * @param teamId team id
     * @return roundScore
     */
    RoundScore getRoundScoreByRoundIdAndTeamId(BigInteger roundId,BigInteger teamId);

    /**
     * 插入轮次分数
     *
     * @param roundScore round score
     */
    void insertRoundScore(RoundScore roundScore);

    /**
     * 更新轮次分数
     *
     * @param roundScore round score
     * @param roundId round id
     * @param teamId team id
     */
    void updateRoundScore(RoundScore roundScore,BigInteger roundId,BigInteger teamId);

    /**
     * 通过轮次删除轮次成绩
     *
     * @param roundId round id
     */
    void deleteRoundScoreByRoundId(BigInteger roundId);

    /**通过课程获取最大轮次序号
     *
     * @param courseId course id
     * @return Integer
     */
    Integer getMaxRoundSerialByCourseId(BigInteger courseId);

    /**
     * 通过课程和轮次序号获取轮次
     *
     * @param courseId course id
     * @param roundSerial round serial id
     * @return round
     */
    Round getRoundByCourseIdAndRoundSerial(BigInteger courseId, int roundSerial);

    /**
     * 通过小组id获取轮次分数
     * @param teamId team id
     * @return List<RoundScore>
     */
    List<RoundScore> getRoundScoreByTeamId(BigInteger teamId);

    /**
     * 通过班级和轮次获取报名数
     *
     * @param courseClassId course class id
     * @param roundId round id
     * @return Integer
     */
    Integer getEnrollNumBycourseClassIdAndRoundId(BigInteger courseClassId,BigInteger roundId);

    /**
     * 更新轮次数
     *
     * @param courseClassId course class id
     * @param roundId round id
     */
    void updateEnrollNum(BigInteger courseClassId,BigInteger roundId);

    /**
     * 通过班级讨论课获取轮次
     *
     * @param seminarControlId seminar control id
     * @return BigInteger
     */
    BigInteger getRoundIdBySeminarControlId(BigInteger seminarControlId);

    /**
     * 更新班级轮次
     *
     * @param roundId round id
     * @param courseClassMap course class map
     */
    void updateCourseClassRound(BigInteger roundId, Map<BigInteger,Integer> courseClassMap);
}