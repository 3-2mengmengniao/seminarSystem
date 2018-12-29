package com.test.seminar.dao.impl;

import com.test.seminar.dao.QuestionDao;
import com.test.seminar.entity.Question;
import com.test.seminar.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionBySeminarControlId(BigInteger seminarControlId) {
        return questionMapper.getQuestionBySeminarControlId(seminarControlId);
    }

    @Override
    public List<Question> getQuestionByTeamId(BigInteger teamId) {
        return questionMapper.getQuestionByTeamId(teamId);
    }

    @Override
    public List<Question> getQuestionByPresentationId(BigInteger presentationId) {
        return questionMapper.getQuestionByPresentationId(presentationId);
    }

    @Override
    public Question getQuestionByPresentationIdAndTeamId(BigInteger presentationId, BigInteger teamId) {
        return questionMapper.getQuestionByPresentationIdAndTeamId(presentationId,teamId);
    }

    @Override
    public void insertQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }

    @Override
    public void updateQuestion(Question question) {
        questionMapper.updateQuestion(question);
    }

    @Override
    public void deleteQuestionByQuestionId(BigInteger questionId) {
        questionMapper.deleteQuestionByQuestionId(questionId);
    }

    @Override
    public Question getQuestionByQuestionId(BigInteger questionId) {
        return questionMapper.getQuestionByQuestionId(questionId);
    }
}
