package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarControl {
    private BigInteger id;
    private BigInteger roundId;
    private BigInteger questionId;
    private BigInteger seminarInfoId;

    public BigInteger getId() {return id; }

    public void setId(BigInteger id) {this.id = id; }

    public BigInteger getRoundId() {return roundId; }

    public void setRoundId(BigInteger roundId) {this.roundId = roundId; }

    public BigInteger getQuestionId() { return questionId; }

    public void setQuestionId(BigInteger questionId) {this.questionId = questionId; }

    public BigInteger getSeminarInfoId() {return seminarInfoId; }

    public void setSeminarInfoId(BigInteger seminarInfoId) {this.seminarInfoId = seminarInfoId; }
}
