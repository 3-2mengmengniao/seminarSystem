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
     * @param roundId Round id
     * @return Round
     */
    Round getRoundByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId course id
     * @return List<Round>
     */
    List<Round> getRoundByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 根据轮次Id获得班级轮次信息
     * @param roundId round id
     * @return List<CourseClassRound>
     */
    List<CourseClassRound> getCourseClassRound(@Param("roundId")BigInteger roundId);

    /**
     * 通过轮次序号和课程获取轮次
     *
     * @param courseId course id
     * @param roundSerial round serial
     * @return round
     */
    Round getRoundByCourseIdAndRoundSerial(@Param("courseId")BigInteger courseId,@Param("roundSerial")int roundSerial);

    /**
     * 通过讨论课信息获取轮次序号
     *
     * @param seminarInfoId seminar info id
     * @return int
     */
    int getRoundSerialBySeminarInfoId(@Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     * 创建新轮次
     * @param round round
     * @param courseId course Id
     */
    void insertRound(@Param("round")Round round,@Param("courseId")BigInteger courseId);

    /**
     * 更新轮次信息
     * @param round round
     */
    void updateRound(@Param("round")Round round);

    /**
     * 删除轮次
     * @param roundId round id
     */
    void deleteRoundByRoundId(@Param("roundId")BigInteger roundId);


    /**
     * 获取某轮次下所有队伍的该轮成绩
     * @param roundId round id
     * @return List<RoundScore>
     */
    List<RoundScore> getRoundScoreByRoundId(@Param("roundId")BigInteger roundId);

    /**
     *获得某队伍所有轮次的成绩
     * @param teamId team id
     * @return List<RoundScore>
     */
    List<RoundScore> getRoundScoreByTeamId(@Param("teamId")BigInteger teamId);

    /**
     *获得某队伍某轮的成绩
     * @param roundId round id
     * @param teamId team id
     * @return RoundScore
     */
    RoundScore getRoundScoreByRoundIdAndTeamId(@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     * 插入轮次成绩
     *
     * @param roundScore round score
     */
    void insertRoundScore(@Param("roundScore")RoundScore roundScore);

    /**
     * 更新轮次成绩
     *
     * @param roundScore round score
     */
    void updateRoundScore(@Param("roundScore")RoundScore roundScore,@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     * 通过课程获取最大轮次序号
     *
     * @param courseId course id
     * @return integer
     */
    Integer getMaxRoundSerialByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 获得某讨论课所属的轮次
     * @param seminarControlId
     * @return
     */
    Round getRoundBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 删除某轮下的所有成绩
     * @param roundId
     */
    void deleteRoundScoreByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 获得某班级在某轮下的报名最大次数
     * @param courseClassId
     * @param roundId
     * @return
     */
    Integer getEnrollNumBycourseClassIdAndRoundId(@Param("courseClassId")BigInteger courseClassId,@Param("roundId")BigInteger roundId);

    /**
     * 更新报名最大次数
     * @param courseClassId
     * @param roundId
     */
    void updateEnrollNum(@Param("courseClassId")BigInteger courseClassId,@Param("roundId")BigInteger roundId);

    /**
     * 获得讨论课所属的轮次的Id
     * @param seminarControlId
     * @return
     */
    BigInteger getRoundIdBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 更新某班在某轮次下的信息
     * @param roundId
     * @param courseClassId
     * @param enrollNumber 最大报名次数
     */
    void updateCourseClassRound(@Param("roundId")BigInteger roundId,@Param("courseClassId")BigInteger courseClassId,@Param("enrollNumber")Integer enrollNumber);
}
