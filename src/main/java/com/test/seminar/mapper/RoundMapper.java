package com.test.seminar.mapper;

import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
import com.test.seminar.entity.SeminarScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface RoundMapper {
    /**
     * 通过轮次ID获得轮次信息
     * @param roundId
     * @return
     */
    Round getRoundByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(@Param("round")Round round);

    /**
     * 更新轮次信息
     * @param round
     */
    void updateRound(@Param("round")Round round);

    /**
     * 删除轮次
     * @param roundId
     */
    void deleteRoundByRoundId(@Param("roundId")BigInteger roundId);

    /**
     *
     * @param roundScoreId
     * @return
     */
    RoundScore getRoundScoreByRoundId(@Param("roundScoreId")BigInteger roundScoreId);

    /**
     *
     * @param roundId
     * @param teamId
     * @return
     */
    RoundScore getRoundScoreByRoundIdAndTeamId(@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     *
     * @param teamId
     * @return
     */
    List<RoundScore> getRoundScoreByTeamId(@Param("teamId")BigInteger teamId);

    /**
     *
     * @param roundScore
     */
    void insertRoundScore(@Param("roundScore")RoundScore roundScore);

    /**
     *
     * @param roundScore
     */
    void updateRoundScore(@Param("roundScore")RoundScore roundScore);

    /**
     *
     * @param roundScoreId
     */
    void deleteRoundScoreByRoundScoreId(@Param("roundScoreId")BigInteger roundScoreId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);
}
