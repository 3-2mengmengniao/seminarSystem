package com.test.seminar.service.impl;


import com.test.seminar.dao.PresentationDao;
import com.test.seminar.dao.QuestionDao;
import com.test.seminar.dao.SeminarDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
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
    @Autowired
    private TeamDao teamDao;
    private Map<BigInteger, SeminarRoom> seminarRoomMap=new HashMap<>();

    @Override
    public SeminarControl beginSeminar(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        seminarControl.setSeminarStatus(1);
        seminarDao.updateSeminarControl(seminarControl);
        List<Presentation> presentationList=seminarControl.getPresentationList();
        for(Presentation presentation:presentationList){
            if(presentation!=null){
                presentation.setPresent(1);
                seminarRoomMap.get(seminarControlId).setPresentationTeam(presentation.getTeam().getSerial());
                presentationDao.updatePresentation(presentation);
                break;
            }
        }
        SeminarRoom seminarRoom=buildSeminarRoomBySeminarControlId(seminarControl);
        seminarRoomMap.put(seminarControlId,seminarRoom);
        return seminarControl;
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
        seminarRoomMap.remove(seminarControlId);
    }

    @Override
    public void selectQuestion(BigInteger seminarControlId) {
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        SeminarRoom seminarRoom=seminarRoomMap.get(seminarControl.getId());
        Map<String,Integer> weightMap=seminarRoom.getWeightMap();
        Map<String,Integer> currentWeightMap=new HashMap<>();
        Presentation activePresentation=getActivePresentation(seminarControl);
        for(Question question:activePresentation.getQuestionList()){
            currentWeightMap.put(question.getSerial().getSerial(),weightMap.get(question.getSerial().getSerial()));
        }
        //查找最大权重的问题
        List<Map.Entry<String,Integer>> mapList = new ArrayList(currentWeightMap.entrySet());
        Collections.sort(mapList, (o1, o2) -> (o2.getValue() - o1.getValue()));
        String selectTeamSerial=mapList.get(0).getKey();
        Question selectQuestion=activePresentation.getQuestionList().get(0);
        for(Question question:activePresentation.getQuestionList()){
            if(question.getSerial().getSerial().equals(selectTeamSerial)){
                selectQuestion=question;
            }
        }
        selectQuestion.setSelected(1);
        questionDao.updateQuestion(selectQuestion);
        Integer newWeight=weightMap.get(selectTeamSerial)-200;
        weightMap.put(selectTeamSerial,newWeight);
        seminarRoomMap.get(seminarControl.getId()).decCount();
        seminarRoom.setQuestionTeam(selectQuestion.getSerial());
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
        Map<String,Integer> weightMap=seminarRoomMap.get(seminarControlId).getWeightMap();
        String serial=teamDao.getSerialByTeamId(teamId).getSerial();
        questionDao.insertQuestion(question,seminarControlId,presentationId,studentId,teamId);
        Integer newWeight=weightMap.get(serial)+20;
        weightMap.put(serial,newWeight);
        seminarRoomMap.get(seminarControl.getId()).incCount();
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
                    seminarRoomMap.get(seminarControlId).setPresentationTeam(presentation.getTeam().getSerial());
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
        seminarRoomMap.get(seminarControl.getId()).setCountZero();
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        presentationDao.updatePresentation(presentation);
    }

    @Override
    public Integer getQuestionNumberWaitToSelect(BigInteger seminarControlId) {
        return seminarRoomMap.get(seminarControlId).getCount();
    }

    @Override
    public Serial getQuestionTeamSerial(BigInteger seminarControlId) {
        return seminarRoomMap.get(seminarControlId).getQuestionTeam();
    }

    @Override
    public Serial getPresentationTeamSerial(BigInteger seminarControlId) {
        return seminarRoomMap.get(seminarControlId).getPresentationTeam();
    }

    private SeminarRoom buildSeminarRoomBySeminarControlId(SeminarControl seminarControl) {
        SeminarRoom seminarRoom=new SeminarRoom();
        //同轮的讨论课信息
        List<SeminarInfo> seminarInfoList=seminarControl.getRound().getSeminarInfoList();
        //同轮同班的其他讨论课
        List<SeminarControl> seminarControlList=new ArrayList<>();
        for(SeminarInfo seminarInfo:seminarInfoList){
            if(!seminarInfo.getId().equals(seminarControl.getSeminarInfo().getId())){
                seminarControlList.add(seminarDao.getSeminarControlByClassIdAndSeminarInfo(seminarControl.getCourseClass().getId(),seminarInfo.getId()));
            }
        }
        //
        Map<String,Integer> weightMap=new HashMap<>();
        for(Team team:seminarControl.getCourseClass().getTeamList()){
            weightMap.put(team.getSerial().getSerial(),0);
        }
        for(SeminarControl otherControl:seminarControlList){
            calculateWeight(weightMap,otherControl,-100,0);
        }
        calculateWeight(weightMap,seminarControl,-200,10);
        seminarRoom.setWeightMap(weightMap);
        return seminarRoom;
    }

    private void calculateWeight(Map<String, Integer> weightMap, SeminarControl seminarControl,int select,int notselect){
        Integer weight;
        List<Question> questionList=seminarControl.getQuestionList();
        for(Question oldQuestion:questionList){
            if(!weightMap.keySet().contains(oldQuestion.getSerial().getSerial()))
                continue;
            weight=weightMap.get(oldQuestion.getSerial().getSerial());
            if(oldQuestion.getSelected()==1){
                weight+=select;
            }
            else{
                weight+=notselect;
            }
            weightMap.put(oldQuestion.getSerial().getSerial(),weight);
        }
    }

    private Presentation getActivePresentation(SeminarControl seminarControl){
        Presentation activePresentation=new Presentation();
        for(Presentation presentation:seminarControl.getPresentationList()){
            if(presentation.getPresent()==1){
                activePresentation=presentation;
                break;
            }
        }
        return  activePresentation;
    }
}
