package com.test.seminar.dao;

import com.test.seminar.entity.SeminarInfo;

import java.math.BigInteger;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface SeminarDao {

    /**
     * 通过ID获取讨论课信息
     * @param SeminarId
     * @return
     */
    SeminarInfo getSeminarBySeminarId(BigInteger SeminarId);

    /**
     * 创建新的讨论课信息
     * @param SeminarInfo
     * @return 新建讨论课信息的ID
     */
    void insertSeminar(SeminarInfo SeminarInfo);

    /**
     * 根据讨论课信息ID更改讨论课信息
     * @param SeminarInfoId
     * @param SeminarInfo
     * @return
     */
    void updateSeminarInfoBySeminarInfoId(BigInteger SeminarInfoId, SeminarInfo SeminarInfo);

    /**
     *
     * @param SeminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger SeminarInfoId);
}
