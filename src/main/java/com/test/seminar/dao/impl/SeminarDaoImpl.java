package com.test.seminar.dao.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.*;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import com.test.seminar.mapper.*;
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
public class SeminarDaoImpl implements SeminarDao {
    @Autowired
    SeminarMapper seminarMapper;
    @Autowired
    RoundMapper roundMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    PresentationMapper presentationMapper;
    @Autowired
    TeamMapper teamMapper;

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        SeminarInfo seminarInfo = seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfoId);
        if (seminarInfo == null) {
            throw new SeminarInfoNotFoundException();
        }
        seminarInfo.setRoundSerial(roundMapper.getRoundSerialBySeminarInfoId(seminarInfoId));
        return seminarInfo;
    }

    @Override
    public SeminarControl getSeminarControlByClassIdAndSeminarInfo(BigInteger classId, BigInteger seminarInfoId) throws SeminarControlNotFoundException {
        SeminarControl seminarControl = seminarMapper.getSeminarControlByClassIdAndSeminarInfo(classId, seminarInfoId);
        if (seminarControl == null) {
            throw new SeminarControlNotFoundException();
        }
        addPresentation(seminarControl);
        return seminarControl;
    }

    @Override
    public List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId) {
        return seminarMapper.getSeminarInfoByRoundId(roundId);
    }

    @Override
    public SeminarInfo getSeminarInfoBySeminarNameAndCourseId(String seminarName, BigInteger courseId) {
        return seminarMapper.getSeminarInfoBySeminarNameAndCourseId(seminarName, courseId);
    }

    @Override
    public SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId) {
        SeminarControl seminarControl = seminarMapper.getSeminarControlBySeminarControlId(seminarControlId);
        addPresentation(seminarControl);
        return seminarControl;
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo, BigInteger roundId, BigInteger courseId) throws RepetitiveRecordException {
        seminarMapper.insertSeminarInfo(seminarInfo, roundId, courseId);
    }

    @Override
    public void insertSeminarControl(SeminarControl seminarControl, BigInteger courseClassId, BigInteger seminarInfoId) {
        seminarMapper.insertSeminarControl(seminarControl, courseClassId, seminarInfoId);
    }

    @Override
    public void updateSeminarInfo(SeminarInfo seminarInfo, BigInteger roundId) throws SeminarInfoNotFoundException {
        if (seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfo.getId()) == null) {
            throw new SeminarInfoNotFoundException();
        }
        seminarMapper.updateSeminarInfo(seminarInfo, roundId);
    }

    @Override
    public void updateSeminarControl(SeminarControl seminarControl) {
        seminarMapper.updateSeminarControl(seminarControl);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        if (seminarMapper.getSeminarInfoBySeminarInfoId(seminarInfoId) == null) {
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
        return seminarMapper.getSeminarInfoBySeminarControlId(seminarControlId);
    }

    @Override
    public List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId) {
        List<SeminarScore> seminarScoreList=seminarMapper.getSeminarScoreBySeminarControlId(seminarControlId);
        for(int i=0;i<seminarScoreList.size();i++){
            seminarScoreList.get(i).setTeamSerial(teamMapper.getTeamSerialByTeamId(seminarScoreList.get(i).getTeamId()));
        }
        return seminarScoreList;
    }

    @Override
    public SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId) {
        return seminarMapper.getSeminarScoreBySeminarControlIdAndTeamId(seminarControlId, teamId);
    }

    @Override
    public List<SeminarScore> getSeminarScoreByTeamId(BigInteger teamId) {
        return seminarMapper.getSeminarScoreByTeamId(teamId);
    }

    @Override
    public void insertSeminarScore(SeminarScore seminarScore, BigInteger seminarControlId, BigInteger teamId) {
        seminarMapper.insertSeminarScore(seminarScore, seminarControlId, teamId);
    }

    @Override
    public void updateSeminarScore(SeminarScore seminarScore, BigInteger seminarControlId, BigInteger teamId) {
        seminarMapper.updateSeminarScore(seminarScore, seminarControlId, teamId);
    }

    @Override
    public void deleteSeminarScoreBySeminarScoreId(BigInteger seminarControlId, BigInteger teamId) {
        seminarMapper.deleteSeminarScoreBySeminarScoreId(seminarControlId, teamId);
    }

    private void addPresentation(SeminarControl seminarControl) {
        List<Presentation> presentationList = presentationMapper.getPresentationBySeminarControlId(seminarControl.getId());
        List<Presentation> presentationListReconstruct = new ArrayList();
        for (int i=0;i<seminarControl.getSeminarInfo().getMaxGroup();i++){
            presentationListReconstruct.add(null);
        }
        for (Presentation presentation : presentationList) {
            presentationListReconstruct.add(presentation.getTeamOrder()-1,presentation);
        }
        seminarControl.setPresentationList(presentationListReconstruct);
    }
}