package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
/**
 * @author xmr
 * @date 2018/11/28
 */
public class SeminarRoom {

    private Integer count;
    private Map<String,Integer> weightMap;
    private Question selectQuestion;
    private Presentation currentPresentation;
    private List<BigInteger> teamIdList;

    public SeminarRoom() {
        this.count = 0;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void incCount(){
        count++;
    }

    public void decCount(){
        count=count-1;
    }

    public void setCountZero(){
        count=0;
    }

    public Map<String, Integer> getWeightMap() {
        return weightMap;
    }

    public void setWeightMap(Map<String, Integer> weightMap) {
        this.weightMap = weightMap;
    }

    public Question getSelectQuestion() {
        return selectQuestion;
    }

    public void setSelectQuestion(Question selectQuestion) {
        this.selectQuestion = selectQuestion;
    }

    public Presentation getCurrentPresentation() {
        return currentPresentation;
    }

    public void setCurrentPresentation(Presentation currentPresentation) {
        this.currentPresentation = currentPresentation;
    }

    public List<BigInteger> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<BigInteger> teamIdList) {
        this.teamIdList = teamIdList;
    }
}
