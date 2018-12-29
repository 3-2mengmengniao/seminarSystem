package com.test.seminar.service;

import com.test.seminar.entity.*;
import com.test.seminar.exception.HaveEnrollException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface SeminarService {

    /**
     * 通过ID获取讨论课信息
     *
     * @param seminarInfoId
     * @return
     * @throws SeminarInfoNotFoundException
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException;

    /**
     * 创建新的讨论课信息
     *
     * @param seminarInfo
     * @throws RepetitiveRecordException
     */
    void insertSeminarInfo(SeminarInfo seminarInfo, BigInteger courseId,Integer roundSerial) throws RepetitiveRecordException;

   /**
     * 更改讨论课信息
     *
     * @param seminarInfo
     * @throws SeminarInfoNotFoundException
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo, BigInteger roundId) throws SeminarInfoNotFoundException;

    /**
     * @param seminarControlId
     * @return
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param seminarControlId
     * @param teamId
     * @return
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);

    /**
     * 删除讨论课信息
     *
     * @param seminarInfoId
     * @throws SeminarInfoNotFoundException
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException;

    /**
     * 通过ID获取某个班级的讨论课信息
     *
     * @param classId
     * @return
     */
    SeminarControl getSeminarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId) throws SeminarControlNotFoundException;

    /**
     * 通过roundID获取round对应的讨论课信息
     *
     * @param roundId
     * @return
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     * 根据传入的轮次列表返回每一个round对应的讨论课信息
     *
     * @param roundList
     * @return
     */
    List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList);

    void insertPresentation(int teamOrder, BigInteger seminarControlId, BigInteger teamId) throws HaveEnrollException;

    void updateSeminarControl(SeminarControl seminarControl);

    void upLoadPPT(HttpServletRequest request, MultipartFile multipartFile, BigInteger seminarControlId, BigInteger teamId) throws IOException;

    void upLoadReport(HttpServletRequest request,MultipartFile multipartFile, BigInteger seminarControlId, BigInteger teamId) throws IOException;

    /**
     * 教师处理共享讨论课请求
     * @param shareSeminarApplication
     */
    void updateShareSeminarApplication(ShareSeminarApplication shareSeminarApplication);

    /**
     * 取消讨论课共享
     * @param subCourse
     */
    void cancelSeminarShare(Course subCourse);

 /**
  * 修改讨论课分数
  * @param presentationScore
  * @param questionScore
  * @param reportScore
  * @param seminarControlId
  * @param teamId
  */
    void updateSeminarScore(Double presentationScore,Double questionScore,Double reportScore,BigInteger seminarControlId,BigInteger teamId);

 /**
  * 修改提问分
  * @param questionScore
  * @param seminarControlId
  * @param teamId
  */
 void updateSeminarScoreForQuestion(Double questionScore,BigInteger seminarControlId,BigInteger teamId);

 /**
  * 更新提问得分
  * @param questionId
  * @param score
  */
 void updateQuestionScore(BigInteger questionId,Double score);

 /**
  * 更新展示得分
  * @param presentationId
  * @param score
  */
 void updatePresentationScore(BigInteger presentationId,Double score);

 }