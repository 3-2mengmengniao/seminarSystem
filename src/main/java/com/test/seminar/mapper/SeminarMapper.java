package com.test.seminar.mapper;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
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
public interface SeminarMapper {

    /**
     * 通过ID获取讨论课信息
     * @param seminarInfoId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(@Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarControl getSeminarControlBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 获取某班级下对应的讨论课控制器
     * @param classId
     * @param seminarInfoId
     * @return
     */
    SeminarControl getSeminarControlByClassIdAndSeminarInfo(@Param("classId") BigInteger classId, @Param("seminarInfoId") BigInteger seminarInfoId);

    /**
     * 获取某轮次下的所有讨论课信息
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(@Param("roundId")BigInteger roundId);

    /**
     *
     * @param seminarName
     * @param courseId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarNameAndCourseId(@Param("seminarName")String seminarName,@Param("courseId")BigInteger courseId);
    /**
     *
     * @param seminarControl
     */
    void insertSeminarControl(@Param("seminarControl")SeminarControl seminarControl,@Param("classId")BigInteger classId, @Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return
     */
    void insertSeminarInfo(@Param("seminarInfo")SeminarInfo seminarInfo,@Param("roundId")BigInteger roundId,@Param("courseId")BigInteger courseId);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfo(@Param("seminarInfo")SeminarInfo seminarInfo,@Param("roundId")BigInteger roundId);

    /**
     *
     * @param seminarControl
     */
    void updateSeminarControl(@Param("seminarControl")SeminarControl seminarControl);

    /**
     *
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(@Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     *
     * @param seminarControlId
     */
    void deleteSeminarControlBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @param teamId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     *
     * @param teamId
     * @return
     */
    List<SeminarScore> getSeminarScoreByTeamId(@Param("teamId")BigInteger teamId);

    /**
     *
     * @param seminarScore
     */
    void insertSeminarScore(@Param("seminarScore")SeminarScore seminarScore,@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     *
     * @param seminarScore
     * @param seminarControlId
     * @param teamId
     */
    void updateSeminarScore(@Param("seminarScore")SeminarScore seminarScore,@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    void deleteSeminarScoreBySeminarScoreId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    List<SeminarScore> getSeminarScoreByRoundIdAndTeamId(@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    void deleteSeminarControlByRoundId(@Param("roundId")BigInteger roundId);

    void deleteSeminarInfoByRoundId(@Param("roundId")BigInteger roundId);
}
