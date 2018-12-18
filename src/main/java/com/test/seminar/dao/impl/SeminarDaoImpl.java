package com.test.seminar.dao.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
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
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException {
        SeminarInfo seminarInfo = seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfoId);
        if(seminarInfo==null) {
            throw new SeminarInfoNotFoundException();
        }
        return seminarInfo;
    }
    @Override
    public SeminarControl getSemniarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId)throws SeminarControlNotFoundException {
        SeminarControl seminarControl = seminarMapper.getSemniarControlByClassIdAndSeminarInfo(classId,seminarInfoId);
        if (seminarControl==null) {
            throw new SeminarControlNotFoundException();
        }
        return seminarControl;
    }

    @Override
    public List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId) {
        return seminarMapper.getSeminarInfoByRoundId(roundId);
    }

    @Override
    public SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId) {
        return seminarMapper.getSeminarControlBySeminarControlId(seminarControlId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo)throws RepetitiveRecordException {
        seminarMapper.insertSeminarInfo(seminarInfo);
    }

    @Override
    public void insertSeminarControl(SeminarControl seminarControl) {
        seminarMapper.insertSeminarControl(seminarControl);
    }

    @Override
    public void updateSeminarInfo(SeminarInfo seminarInfo)throws SeminarInfoNotFoundException {
        if(seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfo.getId())==null) {
            throw new SeminarInfoNotFoundException();
        }
        seminarMapper.updateSeminarInfo(seminarInfo);
    }

    @Override
    public void updateSeminarControl(SeminarControl seminarControl) {
        seminarMapper.updateSeminarControl(seminarControl);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId)throws SeminarInfoNotFoundException {
        if(seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfoId)==null) {
            throw new SeminarInfoNotFoundException();
        }
        seminarMapper.deleteSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void deleteSeminarControlBySeminarControlId(BigInteger seminarControlId) {
        seminarMapper.deleteSeminarControlBySeminarControlId(seminarControlId);
    }
}