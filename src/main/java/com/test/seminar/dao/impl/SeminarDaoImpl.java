package com.test.seminar.dao.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class SeminarDaoImpl implements SeminarDao {
    @Autowired
    SeminarMapper seminarMapper;

    @Override
    public SeminarInfo getSeminarBySeminarId(BigInteger SeminarId) {
        return seminarMapper.getSeminarBySeminarId(SeminarId);
    }

    @Override
    public void insertSeminar(SeminarInfo SeminarInfo) {
        seminarMapper.insertSeminar(SeminarInfo);
    }

    @Override
    public void updateSeminarInfoBySeminarInfoId(SeminarInfo SeminarInfo) {
        seminarMapper.updateSeminarInfoBySeminarInfoId(SeminarInfo);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger SeminarInfoId) {
        seminarMapper.deleteSeminarInfoBySeminarInfoId(SeminarInfoId);
    }
}
