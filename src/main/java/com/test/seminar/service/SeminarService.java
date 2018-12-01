package com.test.seminar.service;

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
     *
     * @param seminarId
     * @return
     * @throws SeminarInfoNotFoundException
     */
    SeminarInfo getSeminarBySeminarId(BigInteger seminarId)throws SeminarInfoNotFoundException;

    /**
     *
     * @param seminarInfo
     * @throws RepetitiveRecordException
     */
    void insertSeminar(SeminarInfo seminarInfo)throws RepetitiveRecordException;

    /**
     *
     * @param seminarInfo
     * @throws SeminarInfoNotFoundException
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo)throws SeminarInfoNotFoundException;

    /**
     *
     * @param seminarInfoId
     * @throws SeminarInfoNotFoundException
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     *
     * @param classId
     * @return
     */
    SeminarControl getSemniarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId)throws SeminarControlNotFoundException;

    /**
     *
     * @param courseId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger courseId);
}
