package com.test.seminar.dao.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.RoundNotFoundException;
import com.test.seminar.mapper.RoundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
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
    public void insertRound(Round round)throws RepetitiveRecordException {
        roundMapper.insertRound(round);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId)throws RoundNotFoundException {
        if(roundMapper.getRoundByRoundId(roundId)==null) {
            throw new RoundNotFoundException();
        }
        roundMapper.deleteRoundByRoundId(roundId);
    }

    @Override
    public void updateRound(Round round)throws RoundNotFoundException {
        if(roundMapper.getRoundByRoundId(round.getId())==null) {
            throw new RoundNotFoundException();
        }
        roundMapper.updateRound(round);
    }

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
}
