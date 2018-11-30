package com.test.seminar.service;

import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarNotFoundException;

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
     * @throws SeminarNotFoundException
     */
    SeminarInfo getseminarBySeminarId(BigInteger seminarId)throws SeminarNotFoundException;

    /**
     *
     * @param seminarInfo
     * @throws RepetitiveRecordException
     */
    void insertSeminar(SeminarInfo seminarInfo)throws RepetitiveRecordException;

    /**
     *
     * @param seminarInfo
     * @throws SeminarNotFoundException
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo)throws SeminarNotFoundException;

    /**
     *
     * @param seminarInfoId
     * @throws SeminarNotFoundException
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarNotFoundException;

    /**
     *
     * @param classId
     * @return
     */
    List<SeminarControl> getSemniarControlByClassId(BigInteger classId);

    /**
     *
     * @param courseId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByCourseId(BigInteger courseId);
}
