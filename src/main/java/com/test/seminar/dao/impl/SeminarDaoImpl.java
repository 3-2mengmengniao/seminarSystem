package com.test.seminar.dao.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class SeminarDaoImpl implements SeminarDao {
    @Autowired
    SeminarMapper seminarMapper;

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) {
        return seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo) {
        seminarMapper.insertSeminarInfo(seminarInfo);
    }

    @Override
    public void updateSeminarInfo(SeminarInfo seminarInfo) {
        seminarMapper.updateSeminarInfo(seminarInfo);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) {
        seminarMapper.deleteSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId) {
        return seminarMapper.getSeminarControlBySeminarControlId(seminarControlId);
    }

    @Override
    public void insertSeminarControl(SeminarControl seminarControl) {
        seminarMapper.insertSeminarControl(seminarControl);
    }

    @Override
    public void updateSeminarControl(SeminarControl seminarControl) {
        seminarMapper.updateSeminarControl(seminarControl);
    }

    @Override
    public void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId) {
        seminarMapper.deleteSeminarControlBySeminarControlId(seminarControlId);
    }

    @Override
    public SeminarControl getSemniarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId) {
        return seminarMapper.getSemniarControlByClassIdAndSeminarInfo(classId, seminarInfoId);
    }

    @Override
    public List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId) {
        return seminarMapper.getSeminarInfoByRoundId(roundId);
    }
}
