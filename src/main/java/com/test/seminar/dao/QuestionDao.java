package com.test.seminar.dao;

import com.test.seminar.entity.Question;

import java.math.BigInteger;
import java.util.List;

public interface QuestionDao {

    List<Question> getQuestionBySeminarControlId(BigInteger seminarControlId);

    List<Question> getQuestionByTeamId(BigInteger teamId);

    List<Question> getQuestionByPresentationId(BigInteger presentationId);

    void insertQuestion(Question question,BigInteger seminarControlId,BigInteger presentationId,BigInteger studentId, BigInteger teamId);

    void updateQuestion(Question question);

    void deleteQuestionByQuestionId(BigInteger questionId);

}
