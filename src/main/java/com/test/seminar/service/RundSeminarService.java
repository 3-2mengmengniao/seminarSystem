package com.test.seminar.service;

import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;

import java.math.BigInteger;

public interface RundSeminarService {

    void beginSeminar(BigInteger seminarControlId);

    void endSeminar(BigInteger seminarControlId);

    Question selectQuestion(BigInteger seminarControlId);

    void addQuestion(BigInteger seminarControlId,BigInteger teamId,BigInteger studentId);

    void updateQuestion(Question question);

    Presentation nextPresentation(BigInteger seminarControlId);

    void updatePresentation(Presentation presentation);
}
