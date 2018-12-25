package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.Map;

public class SeminarRoom {

    private Integer count;
    private Map<String,Integer> weightMap;
    private Serial questionTeam;
    private Serial presentationTeam;

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

    public Serial getQuestionTeam() {
        return questionTeam;
    }

    public void setQuestionTeam(Serial questionTeam) {
        this.questionTeam = questionTeam;
    }

    public Serial getPresentationTeam() {
        return presentationTeam;
    }

    public void setPresentationTeam(Serial presentationTeam) {
        this.presentationTeam = presentationTeam;
    }
}
