package com.test.seminar.service.impl;

import com.test.seminar.dao.PresentationDao;
import com.test.seminar.dao.QuestionDao;
import com.test.seminar.dao.SeminarDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.service.RundSeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RunSeminarServiceImpl implements RundSeminarService {

    @Autowired
    private SeminarDao seminarDao;
    @Autowired
    private PresentationDao presentationDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private QuestionDao questionDao;
    @Override
    public void beginSeminar(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        seminarControl.setSeminarStatus(1);
        List<Presentation> presentationList=seminarControl.getPresentationList();
        for(Presentation presentation:presentationList){
            if(presentation!=null){
                presentation.setPresent(1);
                presentationDao.updatePresentation(presentation);
                break;
            }
        }
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public void endSeminar(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        seminarControl.setSeminarStatus(2);
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public Question selectQuestion(BigInteger seminarControlId) {
        return null;
    }

    @Override
    public void addQuestion(BigInteger seminarControlId, BigInteger teamId,BigInteger studentId) {
        Question question=new Question();
        question.setStudent(studentDao.getStudentByStudentId(studentId));

    }

    @Override
    public void updateQuestion(Question question) {

    }

    @Override
    public Presentation nextPresentation(BigInteger seminarControlId) {
        return null;
    }

    @Override
    public void updatePresentation(Presentation presentation) {

    }
}
