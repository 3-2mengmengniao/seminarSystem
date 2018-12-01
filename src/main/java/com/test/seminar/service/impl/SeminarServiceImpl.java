package com.test.seminar.service.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import com.test.seminar.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SeminarServiceImpl implements SeminarService {

    @Autowired
    private SeminarDao seminarDao;

    @Override
    public SeminarInfo getSeminarBySeminarId(BigInteger seminarId) throws SeminarInfoNotFoundException {
        return null;
    }

    @Override
    public void insertSeminar(SeminarInfo seminarInfo) throws RepetitiveRecordException {

    }

    @Override
    public void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo) throws SeminarInfoNotFoundException {

    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {

    }

    @Override
    public SeminarControl getSemniarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId) throws SeminarControlNotFoundException {
        SeminarControl seminarControl = seminarDao.getSemniarControlByClassIdAndSeminarInfo(classId,seminarInfoId);
        if (seminarControl==null)
            throw new SeminarControlNotFoundException();
        return seminarControl;
    }

    @Override
    public List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId){
        return seminarDao.getSeminarInfoByRoundId(roundId);
    }
}
