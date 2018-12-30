package com.test.seminar.dao;

import com.test.seminar.entity.Question;

import java.math.BigInteger;
import java.util.List;

public interface QuestionDao {

    /**
     * 通过班级讨论课获取提问
     *
     * @param seminarControlId seminar control id
     * @return List<Question>
     */
    List<Question> getQuestionBySeminarControlId(BigInteger seminarControlId);

    /**
     * 通过小组id获取提问
     *
     * @param teamId team id
     * @return List<Question>
     */
    List<Question> getQuestionByTeamId(BigInteger teamId);

    /**
     * 通过展示id获取提问
     *
     * @param presentationId presentation id
     * @return List<Question>
     */
    List<Question> getQuestionByPresentationId(BigInteger presentationId);

    /**
     * 通过展示和小组id获取提问
     *
     * @param presentationId presentation id
     * @param teamId team id
     * @return Question
     */
    Question getQuestionByPresentationIdAndTeamId(BigInteger presentationId,BigInteger teamId);

    /**
     * 插入问题
     *
     * @param question Question
     */
    void insertQuestion(Question question);

    /**
     * 更新问题
     *
     * @param question Question
     */
    void updateQuestion(Question question);

    /**
     * 通过id删除提问
     *
     * @param questionId Question id
     */
    void deleteQuestionByQuestionId(BigInteger questionId);

    /**
     * 通过提问id获取提问
     *
     * @param questionId Question id
     * @return Question
     */
    Question getQuestionByQuestionId(BigInteger questionId);
}
