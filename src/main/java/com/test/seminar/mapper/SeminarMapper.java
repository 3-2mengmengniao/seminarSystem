package com.test.seminar.mapper;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
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
    SeminarControl getSeminarControlBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 获取某班级下对应的讨论课控制器
     * @param classId
     * @param seminarInfoId
     * @return
     */
    SeminarControl getSemniarControlByClassIdAndSeminarInfo(@Param("classId") BigInteger classId,@Param("seminarInfoId") BigInteger seminarInfoId);

    /**
     * 获取某轮次下的所有讨论课信息
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(@Param("roundId")BigInteger roundId);

    /**
     *
     * @param seminarControl
     */
    void insertSeminarControl(@Param("seminarControl")SeminarControl seminarControl);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return
     */
    void insertSeminarInfo(@Param("seminarInfo")SeminarInfo seminarInfo);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfo(@Param("seminarInfo")SeminarInfo seminarInfo);

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
}
