package com.test.seminar.dao.impl;

import com.test.seminar.dao.RoundDao;
import com.test.seminar.entity.Round;
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
    public void insertRound(Round round) {
        roundMapper.insertRound(round);
    }

    @Override
    public void deleteRoundByRoundId(BigInteger roundId) {
        roundMapper.deleteRoundByRoundId(roundId);
    }

    @Override
    public void updateRound(Round round) {
        roundMapper.updateRound(round);
    }

    @Override
    public Round getRoundByRoundId(BigInteger roundId) {
        return roundMapper.getRoundByRoundId(roundId);
    }

    @Override
    public List<Round> getRoundByCourseId(BigInteger courseId) {
        return roundMapper.getRoundByCourseId(courseId);
    }
}
