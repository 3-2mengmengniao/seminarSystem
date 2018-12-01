package com.test.seminar.service.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;
import com.test.seminar.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundDao roundDao;

    @Override
    public void insertRound(BigInteger classId, int enrollNumber, int calculateMethod) throws RepetitiveRecordException {
        Round newround=new Round();
        newround.setEnrollNumber(enrollNumber);
        newround.setClassId(classId);
        newround.setCalculateMethod(calculateMethod);
        roundDao.insertRound(newround);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {

    }

    @Override
    public void updateRound(Round round)throws RoundNotFoundException{

    }

    @Override
    public Round getRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {
        return null;
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId) {
        return roundDao.getRoundByCourseId(courseId);
    }
}
