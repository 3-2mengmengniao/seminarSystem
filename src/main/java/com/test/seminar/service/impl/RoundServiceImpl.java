package com.test.seminar.service.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;
import com.test.seminar.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundDao roundDao;

    @Override
    public void insertRound(Round round) throws RepetitiveRecordException {
        roundDao.insertRound(round);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {
        if(roundDao.getRoundByRoundId(roundId)==null) {
            throw new RoundNotFoundException();
        }
        roundDao.deleteRoundByRoundId(roundId);
    }

    @Override
    public void updateRound(Round round)throws RoundNotFoundException{
        if(roundDao.getRoundByRoundId(round.getId())==null) {
            throw new RoundNotFoundException();
        }
        roundDao.updateRound(round);
    }

    @Override
    public Round getRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {
        Round round=roundDao.getRoundByRoundId(roundId);
        if(round==null) {
            throw new RoundNotFoundException();
        }
        return round;
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId) {
         List<Round> roundlist = roundDao.getRoundByCourseId(courseId);
         return roundlist;
    }
}
