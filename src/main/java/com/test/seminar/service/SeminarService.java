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
     * @param seminarInfoId seminar info id
     * @return SeminarInfo
     * @throws SeminarInfoNotFoundException
     */
    SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException;

    /**
     * 创建新的讨论课信息
     *
     * @param seminarInfo Seminar Info
     * @param courseId course id
     * @param roundSerial round serial
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertSeminarInfo(SeminarInfo seminarInfo, BigInteger courseId,Integer roundSerial) throws RepetitiveRecordException;

   /**
     * 更改讨论课信息
     *
     * @param seminarInfo Seminar Info
     * @throws SeminarInfoNotFoundException seminar info not found
     */
    void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo, BigInteger roundId) throws SeminarInfoNotFoundException;

    /**
     * 通过id获取班级讨论课
     *
     * @param seminarControlId seminar control id
     * @return SeminarControl
     */
    SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId);

    /**
     * 通过班级讨论课获取讨论课成绩
     *
     * @param seminarControlId Seminar Control id
     * @return List<SeminarScore>
     */
    List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId);

    /**
     * 通过班级讨论课和小组获取讨论课成绩
     *
     * @param seminarControlId seminar Control id
     * @param teamId team id
     * @return SeminarScore
     */
    SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);

    /**
     * 删除讨论课信息
     *
     * @param seminarInfoId seminar info id
     * @throws SeminarInfoNotFoundException seminar info not found
     */
    void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException;

    /**
     * 通过ID获取某个班级的讨论课信息
     *
     * @param classId class id
     * @return SeminarControl
     */
    SeminarControl getSeminarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId) throws SeminarControlNotFoundException;

    /**
     * 通过roundID获取round对应的讨论课信息
     *
     * @param roundId round id
     * @return List<SeminarInfo>
     */
    List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId);

    /**
     * 根据传入的轮次列表返回每一个round对应的讨论课信息
     *
     * @param roundList round list
     * @return List<List<SeminarInfo>>
     */
    List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList);

    void insertPresentation(int teamOrder, BigInteger seminarControlId, BigInteger teamId) throws HaveEnrollException;

    void updateSeminarControl(SeminarControl seminarControl);

    void upLoadPPT(HttpServletRequest request, MultipartFile multipartFile, BigInteger seminarControlId, BigInteger teamId) throws IOException;

    void upLoadReport(HttpServletRequest request,MultipartFile multipartFile, BigInteger seminarControlId, BigInteger teamId) throws IOException;

    /**
     * 教师处理共享讨论课请求
     * @param shareSeminarApplication hare seminar application
     */
    void updateShareSeminarApplication(ShareSeminarApplication shareSeminarApplication);

    /**
     * 取消讨论课共享
     * @param subCourse sub course
     */
    void cancelSeminarShare(Course subCourse);

 /**
  * 修改讨论课分数
  * @param presentationScore presentation score
  * @param questionScore question score
  * @param reportScore report score
  * @param seminarControlId seminar control id
  * @param teamId team id
  */
    void updateSeminarScore(Double presentationScore,Double questionScore,Double reportScore,BigInteger seminarControlId,BigInteger teamId);

 /**
  * 修改提问分
  * @param questionScore question score
  * @param seminarControlId seminar control id
  * @param teamId team id
  */
 void updateSeminarScoreForQuestion(Double questionScore,BigInteger seminarControlId,BigInteger teamId);

 /**
  * 更新提问得分
  * @param questionId question id
  * @param score score
  */
 void updateQuestionScore(BigInteger questionId,Double score);

 /**
  * 更新展示得分
  * @param presentationId presentation id
  * @param score score
  */
 void updatePresentationScore(BigInteger presentationId,Double score);

 /**
  * 删除报名
  * @param seminarControlId seminar control id
  * @param teamId team id
  */
 void deletePresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);
 }