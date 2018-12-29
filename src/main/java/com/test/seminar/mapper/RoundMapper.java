package com.test.seminar.mapper;

import com.test.seminar.entity.CourseClassRound;
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
     * 根据轮次Id获得班级轮次信息
     * @param roundId
     * @return
     */
    List<CourseClassRound> getCourseClassRound(@Param("roundId")BigInteger roundId);

    /**
     *
     * @param courseId
     * @param roundSerial
     * @return
     */
    Round getRoundByCourseIdAndRoundSerial(@Param("courseId")BigInteger courseId,@Param("roundSerial")int roundSerial);

    /**
     *
     * @param seminarInfoId
     * @return
     */
    int getRoundSerialBySeminarInfoId(@Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(@Param("round")Round round,@Param("courseId")BigInteger courseId);

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
     * 获取某轮次下所有队伍的该轮成绩
     * @param roundId
     * @return
     */
    List<RoundScore> getRoundScoreByRoundId(@Param("roundId")BigInteger roundId);

    /**
     *
     * @param teamId
     * @return
     */
    List<RoundScore> getRoundScoreByTeamId(@Param("teamId")BigInteger teamId);

    RoundScore getRoundScoreByRoundIdAndTeamId(@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     *
     * @param roundScore
     */
    void insertRoundScore(@Param("roundScore")RoundScore roundScore);

    /**
     *
     * @param roundScore
     */
    void updateRoundScore(@Param("roundScore")RoundScore roundScore,@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     *
     * @param courseId
     * @return
     */
    Integer getMaxRoundSerialByCourseId(@Param("courseId")BigInteger courseId);

    Round getRoundBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    void deleteRoundScoreByRoundId(@Param("roundId")BigInteger roundId);

    Integer getEnrollNumBycourseClassIdAndRoundId(@Param("courseClassId")BigInteger courseClassId,@Param("roundId")BigInteger roundId);

    void updateEnrollNum(@Param("courseClassId")BigInteger courseClassId,@Param("roundId")BigInteger roundId);

    BigInteger getRoundIdBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    void updateCourseClassRound(@Param("roundId")BigInteger roundId,@Param("courseClassId")BigInteger courseClassId,@Param("enrollNumber")Integer enrollNumber);
}
