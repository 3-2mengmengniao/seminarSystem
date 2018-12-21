package com.test.seminar.service.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.Round;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import com.test.seminar.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeminarServiceImpl implements SeminarService {

    @Autowired
    private SeminarDao seminarDao;

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        return seminarDao.getSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo, BigInteger courseId, BigInteger roundId) throws RepetitiveRecordException {

    }

    @Override
    public void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo,BigInteger roundId) throws SeminarInfoNotFoundException {
        seminarDao.updateSeminarInfo(seminarInfo,roundId);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        seminarDao.deleteSeminarInfoBySeminarInfoId(seminarInfoId);
    }
}
