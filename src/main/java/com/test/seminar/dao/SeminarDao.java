package com.test.seminar.dao;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface SeminarDao {

    /**
     * 通过ID获取讨论课信息
     * @param seminarInfoId
     * @return
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return
     */
    void insertSeminarInfo(SeminarInfo seminarInfo);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfo(SeminarInfo seminarInfo);

    /**
     *
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param seminarControl
     */
    void insertSeminarControl(SeminarControl seminarControl);

    /**
     *
     * @param seminarControl
     */
    void updateSeminarControl(SeminarControl seminarControl);

    /**
     * 
     * @param seminarControlId
     */
    void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 获取某班级下对应的讨论课控制器
     * @param classId
     * @param seminarInfoId
     * @return
     */
    SeminarControl getSemniarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId);

    /**
     * 获取某轮次下的所有讨论课信息
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

}
