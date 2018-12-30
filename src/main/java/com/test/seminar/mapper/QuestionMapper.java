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

    /**
     * 获得某讨论课下的所有提问
     * @param seminarControlId
     * @return
     */
    List<Question> getQuestionBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 获得某组的提问
     * @param teamId
     * @return
     */
    List<Question> getQuestionByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 获得某展示下的所有提问
     * @param presentationId
     * @return
     */
    List<Question> getQuestionByPresentationId(@Param("presentationId")BigInteger presentationId);

    /**
     * 获得某展示下某组的提问
     * @param presentationId
     * @param teamId
     * @return
     */
    Question getQuestionByPresentationIdAndTeamId(@Param("presentationId")BigInteger presentationId,@Param("teamId")BigInteger teamId);

    /**
     * 创建提问
     * @param question
     */
    void insertQuestion(Question question);

    /**
     * 更新提问
     * @param question
     */
    void updateQuestion(@Param("question")Question question);

    /**
     * 删除提问
     * @param questionId
     */
    void deleteQuestionByQuestionId(@Param("questionId")BigInteger questionId);

    /**
     * 根据ID获得提问
     * @param questionId
     * @return
     */
    Question getQuestionByQuestionId(@Param("questionId") BigInteger questionId);
}
