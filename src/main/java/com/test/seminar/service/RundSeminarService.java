package com.test.seminar.service;

import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.Serial;

import java.math.BigInteger;
import java.util.Date;

public interface RundSeminarService {

    SeminarControl beginSeminar(BigInteger seminarControlId);

    void endSeminar(BigInteger seminarControlId,Date strtodate);

    void selectQuestion(BigInteger seminarControlId);

    void addQuestion(BigInteger seminarControlId,BigInteger teamId,BigInteger studentId);

    void updateQuestion(Question question);

    void nextPresentation(BigInteger seminarControlId);

    void updatePresentation(Presentation presentation);

    Integer getQuestionNumberWaitToSelect(BigInteger seminarControlId);

    Serial getQuestionTeamSerial(BigInteger seminarControlId);

    Serial getPresentationTeamSerial(BigInteger seminarControlId);
}
