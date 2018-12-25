package com.test.seminar.service.impl;


import com.test.seminar.dao.PresentationDao;
import com.test.seminar.dao.QuestionDao;
import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.service.RundSeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class RunSeminarServiceImpl implements RundSeminarService {

    @Autowired
    private SeminarDao seminarDao;
    @Autowired
    private PresentationDao presentationDao;
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
        for(Presentation presentation:seminarControl.getPresentationList()){
            if(presentation.getPresent()==1){
                presentation.setPresent(0);
                presentationDao.updatePresentation(presentation);
            }
        }
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public Question selectQuestion(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        Presentation activePresentation=new Presentation();
        for(Presentation presentation:seminarControl.getPresentationList()){
            if(presentation.getPresent()==1){
                activePresentation=presentation;
                break;
            }
        }
        List<SeminarInfo> seminarInfoList=seminarControl.getRound().getSeminarInfoList();
        List<SeminarControl> seminarControlList=new ArrayList<>();
        for(SeminarInfo seminarInfo:seminarInfoList){
            if(!seminarInfo.getId().equals(seminarControl.getSeminarInfo().getId())){
                seminarControlList.add(seminarDao.getSeminarControlByClassIdAndSeminarInfo(seminarControl.getCourseClass().getId(),seminarInfo.getId()));
            }
        }
        Map<String,Integer> weightMap=new HashMap<>();
        for(Question question:activePresentation.getQuestionList()){
            weightMap.put(question.getTeamSerial().getSerial(),0);
        }
        for(SeminarControl otherControl:seminarControlList){
            calculateWeight(weightMap,otherControl,-100,0);
        }
        calculateWeight(weightMap,seminarControl,-200,10);
        //查找最大权重的问题
        List<Map.Entry<String,Integer>> mapList = new ArrayList(weightMap.entrySet());
        Collections.sort(mapList, (o1, o2) -> (o2.getValue() - o1.getValue()));
        String selectTeamSerial=mapList.get(0).getKey();
        Question selectQuestion=activePresentation.getQuestionList().get(0);
        for(Question question:activePresentation.getQuestionList()){
            if(question.getTeamSerial().getSerial().equals(selectTeamSerial)){
                selectQuestion=question;
            }
        }
        selectQuestion.setSelected(1);
        questionDao.updateQuestion(selectQuestion);
        return selectQuestion;
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
                if(flag){
                    presentation.setPresent(1);
                    presentationDao.updatePresentation(presentation);
                    break;
                }
                if(presentation.getPresent()==1){
                    presentation.setPresent(0);
                    presentationDao.updatePresentation(presentation);
                    flag=true;
                }
            }
        }
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        presentationDao.updatePresentation(presentation);
    }

    private void calculateWeight(Map<String, Integer> weightMap, SeminarControl seminarControl,int select,int notselect){
        Integer weight;
        List<Question> questionList=seminarControl.getQuestionList();
        for(Question oldQuestion:questionList){
            if(!weightMap.keySet().contains(oldQuestion.getTeamSerial().getSerial()))
                continue;
            weight=weightMap.get(oldQuestion.getTeamSerial().getSerial());
            if(oldQuestion.getSelected()==1){
                weight+=select;
            }
            else{
                weight+=notselect;
            }
            weightMap.put(oldQuestion.getTeamSerial().getSerial(),weight);
        }
    }
}
