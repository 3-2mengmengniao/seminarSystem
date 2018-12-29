package com.test.seminar.service;

import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
/**
 * @author xmr
 * @date 2018/11/28
 */
public interface RunSeminarService {

    SeminarControl beginSeminar(BigInteger seminarControlId);

    void endSeminar(BigInteger seminarControlId,Date strtodate);

    void selectQuestion(BigInteger seminarControlId);

    void addQuestion(BigInteger seminarControlId,BigInteger teamId,BigInteger studentId);

    void updateQuestion(Question question);

    void nextPresentation(BigInteger seminarControlId);

    void updatePresentation(Presentation presentation);

    Integer getQuestionNumberWaitToSelect(BigInteger seminarControlId);

    Question getSelectQuestion(BigInteger seminarControlId);

    Presentation getCurrentPresentation(BigInteger seminarControlId);

    List<BigInteger> getTeamIdInQuestion(BigInteger seminarControlId);
}
