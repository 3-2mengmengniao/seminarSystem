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
    public SeminarInfo getSeminarBySeminarId(BigInteger seminarId) throws SeminarInfoNotFoundException {
        SeminarInfo seminarInfo = seminarDao.getSeminarInfoBySeminarInfoId(seminarId);
        if(seminarInfo==null)
            throw new SeminarInfoNotFoundException();
        return seminarInfo;
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo) throws RepetitiveRecordException {
        seminarDao.insertSeminarInfo(seminarInfo);
    }

    @Override
    public void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo) throws SeminarInfoNotFoundException {
        if(seminarDao.getSeminarInfoBySeminarInfoId(seminarInfo.getId())==null)
            throw new SeminarInfoNotFoundException();
        seminarDao.updateSeminarInfo(seminarInfo);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        if(seminarDao.getSeminarInfoBySeminarInfoId(seminarInfoId)==null)
            throw new SeminarInfoNotFoundException();
        seminarDao.deleteSeminarInfoBySeminarInfoId(seminarInfoId);
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

    @Override
    public List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList) {
        List<List<SeminarInfo>> SeminarInfoOrderByRoundId= new ArrayList<List<SeminarInfo>>();
        List<SeminarInfo> temp;
        for(int i=0;i<roundList.size();i++)
        {
            System.out.println(roundList.get(i).getId());
            temp=getSeminarInfoByRoundId(roundList.get(i).getId());
            System.out.println(temp);
            SeminarInfoOrderByRoundId.add(i,temp);
        }
        return SeminarInfoOrderByRoundId;
    }
}
