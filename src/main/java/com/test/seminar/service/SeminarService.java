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
    void insertSeminarInfo(SeminarInfo seminarInfo)throws RepetitiveRecordException;

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @throws SeminarInfoNotFoundException
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo)throws SeminarInfoNotFoundException;

    /**
     * 删除讨论课信息
     * @param seminarInfoId
     * @throws SeminarInfoNotFoundException
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException;

    /**
     * 通过ID获取某个班级的讨论课信息
     * @param classId
     * @return
     */
    SeminarControl getSemniarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId)throws SeminarControlNotFoundException;

    /**
     * 通过roundID获取round对应的讨论课信息
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     * 根据传入的轮次列表返回每一个round对应的讨论课信息
     * @param roundList
     * @return
     */
    List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList);
}
