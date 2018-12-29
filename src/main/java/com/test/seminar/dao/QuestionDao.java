package com.test.seminar.dao;

import com.test.seminar.entity.Question;

import java.math.BigInteger;
import java.util.List;

/**
 * @author xmr
 * @date 2018/11/28
 */

public interface QuestionDao {

    List<Question> getQuestionBySeminarControlId(BigInteger seminarControlId);

    List<Question> getQuestionByTeamId(BigInteger teamId);

    List<Question> getQuestionByPresentationId(BigInteger presentationId);

    Question getQuestionByPresentationIdAndTeamId(BigInteger presentationId,BigInteger teamId);


    void insertQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestionByQuestionId(BigInteger questionId);

    Question getQuestionByQuestionId(BigInteger questionId);
}
