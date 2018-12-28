package com.test.seminar.mapper;

import com.test.seminar.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface QuestionMapper {

    List<Question> getQuestionBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    List<Question> getQuestionByTeamId(@Param("teamId")BigInteger teamId);

    List<Question> getQuestionByPresentationId(@Param("presentationId")BigInteger presentationId);

    Question getQuestionByPresentationIdAndTeamId(@Param("presentationId")BigInteger presentationId,@Param("teamId")BigInteger teamId);

    void insertQuestion(Question question);

    void updateQuestion(@Param("question")Question question);

    void deleteQuestionByQuestionId(@Param("questionId")BigInteger questionId);
}
