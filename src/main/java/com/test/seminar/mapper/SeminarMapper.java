package com.test.seminar.mapper;

import com.test.seminar.entity.SeminarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

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
     * 更改讨论课信息
     * @param SeminarInfo
     * @return
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo SeminarInfo);

    /**
     *
     * @param SeminarInfoId
     * @return
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger SeminarInfoId);
}
