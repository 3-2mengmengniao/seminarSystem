package com.test.seminar.dao;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.entity.SeminarScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;

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
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     * 通过roundID获取round对应的讨论课信息
     * @param seminarControlId
     * @return
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return
     */
    void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws RepetitiveRecordException;

    /**
     *
     * @param seminarControl
     */
    void insertSeminarControl(SeminarControl seminarControl,BigInteger classId,BigInteger seminarInfoId);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws SeminarInfoNotFoundException;

    /**
     *
     * @param seminarControl
     */
    void updateSeminarControl(SeminarControl seminarControl);

    /**
     * 删除讨论课信息
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;



    /**
     *
     * @param seminarControlId
     */
    void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId);
}