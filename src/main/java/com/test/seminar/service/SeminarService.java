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
    void insertSeminarInfo(SeminarInfo seminarInfo)throws RepetitiveRecordException;

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
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     * 根据传入的轮次列表返回每一个round对应的讨论课信息，
     * @param roundList
     * @return
     */
    List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList);
}
