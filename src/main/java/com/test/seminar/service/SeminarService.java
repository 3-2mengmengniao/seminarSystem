package com.test.seminar.service;

import com.test.seminar.entity.Round;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface SeminarService {

    /**
     * 通过ID获取讨论课信息
     * @param seminarInfoId
     * @return
     * @throws SeminarInfoNotFoundException
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @throws RepetitiveRecordException
     */
    void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger courseId,BigInteger roundId)throws RepetitiveRecordException;


    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @throws SeminarInfoNotFoundException
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo,BigInteger roundId)throws SeminarInfoNotFoundException;

    /**
     * 删除讨论课信息
     * @param seminarInfoId
     * @throws SeminarInfoNotFoundException
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;
}
