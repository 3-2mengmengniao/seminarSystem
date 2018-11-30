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
     * @param seminarId
     * @return
     */
    SeminarInfo getseminarBySeminarId(BigInteger seminarId);

    /**
     * 创建新的讨论课信息
     * @param seminarInfo
     * @return 新建讨论课信息的ID
     */
    void insertSeminar(SeminarInfo seminarInfo);

    /**
     * 更改讨论课信息
     * @param seminarInfo
     * @return
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo);

    /**
     *
     * @param seminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId);

    List<SeminarControl> getSemniarControlByClassId(BigInteger classId);

    List<SeminarInfo> getSeminarInfoByCourseId(BigInteger courseId);
}
