package com.test.seminar.dao.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.entity.SeminarScore;
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
    public void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws RepetitiveRecordException {
        seminarMapper.insertSeminarInfo(seminarInfo,roundId);
    }

    @Override
    public void insertSeminarControl(SeminarControl seminarControl,BigInteger courseClassId,BigInteger seminarInfoId) {
        seminarMapper.insertSeminarControl(seminarControl,courseClassId,seminarInfoId);
    }

    @Override
    public void updateSeminarInfo(SeminarInfo seminarInfo,BigInteger roundId)throws SeminarInfoNotFoundException {
        if(seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfo.getId())==null) {
            throw new SeminarInfoNotFoundException();
        }
        seminarMapper.updateSeminarInfo(seminarInfo,roundId);
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

    @Override
    public SeminarInfo getSeminarInfoBySeminarControlId(BigInteger seminarControlId) {
        return seminarMapper.getSeminarInfoBySeminarControlId( seminarControlId);
    }

    @Override
    public SeminarScore getSeminarScoreBySeminarScoreId(BigInteger seminarScoreId) {
        return seminarMapper.getSeminarScoreBySeminarScoreId(seminarScoreId);
    }

    @Override
    public SeminarScore getSeminarScoreBySeminarControlId(BigInteger seminarControlId) {
        return seminarMapper.getSeminarScoreBySeminarControlId(seminarControlId);
    }

    @Override
    public SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId) {
        return seminarMapper.getSeminarScoreBySeminarControlIdAndTeamId(seminarControlId,teamId);
    }

    @Override
    public List<SeminarScore> getSeminarScoreByTeamId(BigInteger teamId) {
        return seminarMapper.getSeminarScoreByTeamId(teamId);
    }

    @Override
    public void insertSeminarScore(SeminarScore seminarScore) {
        seminarMapper.insertSeminarScore(seminarScore);
    }

    @Override
    public void updateSeminarScore(SeminarScore seminarScore) {
        seminarMapper.updateSeminarScore(seminarScore);
    }

    @Override
    public void deleteSeminarScoreBySeminarScoreId(BigInteger seminarScoreId) {
        seminarMapper.deleteSeminarScoreBySeminarScoreId(seminarScoreId);
    }
}