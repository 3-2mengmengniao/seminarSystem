package com.test.seminar.service.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
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
    public void insertRound(Round round,BigInteger courseId) throws RepetitiveRecordException {
        roundDao.insertRound(round,courseId);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {
        roundDao.deleteRoundByRoundId(roundId);
    }

    @Override
    public void updateRound(Round round)throws RoundNotFoundException{
        roundDao.updateRound(round);
    }

    @Override
    public Round getRoundByRoundId(BigInteger roundId) throws RoundNotFoundException {
        return roundDao.getRoundByRoundId(roundId);
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId) {
         return roundDao.getRoundByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId,BigInteger teamId){
        return roundDao.getRoundByCourseId(courseId,teamId);
    }

    @Override
    public List<RoundScore> getRoundScoreByTeamId(BigInteger teamId) {
        return roundDao.getRoundScoreByTeamId(teamId);
    }
}
