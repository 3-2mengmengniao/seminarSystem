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
        BigInteger presentationId=new BigInteger("-1");
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        for(Presentation presentation:seminarControl.getPresentationList()){
            if(presentation!=null){
                if(presentation.getPresent()==1){
                    presentationId=presentation.getId();
                }
            }
        }
        questionDao.insertQuestion(question,seminarControlId,presentationId,studentId,teamId);
    }

    @Override
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    @Override
    public void nextPresentation(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        boolean flag=false;
        for(Presentation presentation:seminarControl.getPresentationList()){
            if(presentation!=null){
                if(presentation.getPresent()==1){
                    presentation.setPresent(0);
                    presentationDao.updatePresentation(presentation);
                    flag=true;
                }
                if(flag){
                    presentation.setPresent(1);
                    presentationDao.updatePresentation(presentation);
                    flag=false;
                }
            }
        }
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        presentationDao.updatePresentation(presentation);
    }
}
