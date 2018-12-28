package com.test.seminar.dao.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
import com.test.seminar.entity.RoundScore;
import com.test.seminar.entity.SeminarScore;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;
import com.test.seminar.mapper.RoundMapper;
import com.test.seminar.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class RoundDaoImpl implements RoundDao {
    @Autowired
    RoundMapper roundMapper;

    @Override
    public Round getRoundByRoundId(BigInteger roundId)throws RoundNotFoundException {
        Round round=roundMapper.getRoundByRoundId(roundId);
        if(round==null) {
            throw new RoundNotFoundException();
        }
        return round;
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId) {
        return roundMapper.getRoundByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId,BigInteger teamId){
        List<Round> roundList=roundMapper.getRoundByCourseId(courseId);
        for(Round round:roundList){
            round.getRoundScoreList().removeIf(roundScore-> {
                return !roundScore.getTeamId().equals(teamId);
            });
        }
        return roundList;
    }

    @Override
    public int getRoundSerialBySeminarInfoId(BigInteger seminarInfoId){
        return roundMapper.getRoundSerialBySeminarInfoId(seminarInfoId);
    }


    @Override
    public void insertRound(Round round, BigInteger courseId)throws RepetitiveRecordException {
        roundMapper.insertRound(round,courseId);
    }

    @Override
    public void updateRound(Round round)throws RoundNotFoundException {
        if(roundMapper.getRoundByRoundId(round.getId())==null) {
            throw new RoundNotFoundException();
        }
        roundMapper.updateRound(round);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException {
        if(roundMapper.getRoundByRoundId(roundId)==null) {
            throw new RoundNotFoundException();
        }
        roundMapper.deleteRoundByRoundId(roundId);
    }

    @Override
    public List<RoundScore> getRoundScoreByRoundId(BigInteger roundId) {
        return roundMapper.getRoundScoreByRoundId(roundId);
    }

    @Override
    public void insertRoundScore(RoundScore roundScore) {
        roundMapper.insertRoundScore(roundScore);
    }

    @Override
    public void updateRoundScore(RoundScore roundScore,BigInteger roundId,BigInteger teamId) {
        roundMapper.updateRoundScore(roundScore,roundId,teamId);
    }

    @Override
    public void deleteRoundScoreByRoundId(BigInteger roundId) {
        roundMapper.deleteRoundScoreByRoundId(roundId);
    }

    @Override
    public int getMaxRoundSerialByCourseId(BigInteger courseId) {
        return roundMapper.getMaxRoundSerialByCourseId(courseId);
    }

    @Override
    public Round getRoundByCourseIdAndRoundSerial(BigInteger courseId,int roundSerial){
        return roundMapper.getRoundByCourseIdAndRoundSerial(courseId,roundSerial);
    }

    @Override
    public List<RoundScore> getRoundScoreByTeamId(BigInteger teamId) {
        return roundMapper.getRoundScoreByTeamId(teamId);
    }

    @Override
    public Integer getEnrollNumBycourseClassIdAndRoundId(BigInteger courseClassId,BigInteger roundId){
        return roundMapper.getEnrollNumBycourseClassIdAndRoundId(courseClassId,roundId);
    }

    @Override
    public void updateEnrollNum(BigInteger courseClassId,BigInteger roundId){
        roundMapper.updateEnrollNum(courseClassId,roundId);
    }
}