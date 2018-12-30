package com.test.seminar.service;

import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface RunSeminarService {

    /**
     * 开始讨论课
     * @param seminarControlId
     * @return
     */
    SeminarControl beginSeminar(BigInteger seminarControlId);

    /**
     * 结束讨论课
     * @param seminarControlId
     * @param strtodate
     */
    void endSeminar(BigInteger seminarControlId,Date strtodate);

    /**
     * 抽取问题
     * @param seminarControlId
     */
    void selectQuestion(BigInteger seminarControlId);

    /**
     * 增加提问
     * @param seminarControlId
     * @param teamId
     * @param studentId
     */
    void addQuestion(BigInteger seminarControlId,BigInteger teamId,BigInteger studentId);

    /**
     * 下组展示
     * @param seminarControlId
     */
    void nextPresentation(BigInteger seminarControlId);

    /**
     * 获得待抽取问题数量
     * @param seminarControlId
     * @return
     */
    Integer getQuestionNumberWaitToSelect(BigInteger seminarControlId);

    /**
     * 获得正在被提问的问题信息
     * @param seminarControlId
     * @return
     */
    Question getSelectQuestion(BigInteger seminarControlId);

    /**
     * 获得当前正在进行的展示信息
     * @param seminarControlId
     * @return
     */
    Presentation getCurrentPresentation(BigInteger seminarControlId);

    /**
     * 获得已提问小组名单
     * @param seminarControlId
     * @return
     */
    List<BigInteger> getTeamIdInQuestion(BigInteger seminarControlId);
}
