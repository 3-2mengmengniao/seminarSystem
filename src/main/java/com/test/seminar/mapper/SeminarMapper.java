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
     *根据ID获得讨论课信息
     * @param seminarControlId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *根据ID获得讨论课
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
     *创建讨论课
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
     *更新讨论课
     * @param seminarControl
     */
    void updateSeminarControl(@Param("seminarControl")SeminarControl seminarControl);

    /**
     *删除讨论课信息
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(@Param("seminarInfoId")BigInteger seminarInfoId);

    /**
     *删除讨论课
     * @param seminarControlId
     */
    void deleteSeminarControlBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *获得某讨论课下的所有成绩
     * @param seminarControlId
     * @return
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     *获得某讨论课下某组的成绩
     * @param seminarControlId
     * @param teamId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     *获得某队伍的所有讨论课成绩
     * @param teamId
     * @return
     */
    List<SeminarScore> getSeminarScoreByTeamId(@Param("teamId")BigInteger teamId);

    /**
     *创建讨论课分数
     * @param seminarScore
     */
    void insertSeminarScore(@Param("seminarScore")SeminarScore seminarScore,@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     *更新讨论课分数
     * @param seminarScore
     * @param seminarControlId
     * @param teamId
     */
    void updateSeminarScore(@Param("seminarScore")SeminarScore seminarScore,@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     * 删除讨论课分数
     * @param seminarControlId
     * @param teamId
     */
    void deleteSeminarScoreBySeminarScoreId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     * 获得某轮某组的所有讨论课成绩
     * @param roundId
     * @param teamId
     * @return
     */
    List<SeminarScore> getSeminarScoreByRoundIdAndTeamId(@Param("roundId")BigInteger roundId,@Param("teamId")BigInteger teamId);

    /**
     * 删除某轮下的所有讨论课
     * @param roundId
     */
    void deleteSeminarControlByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 删除某轮下的所有讨论课信息
     * @param roundId
     */
    void deleteSeminarInfoByRoundId(@Param("roundId")BigInteger roundId);
}
