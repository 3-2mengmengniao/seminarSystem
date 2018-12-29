package com.test.seminar.service.impl;

import com.test.seminar.dao.*;
import com.test.seminar.entity.*;
import com.test.seminar.exception.HaveEnrollException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import com.test.seminar.service.SeminarService;
import com.test.seminar.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeminarServiceImpl implements SeminarService {

    @Autowired
    private SeminarDao seminarDao;
    @Autowired
    private RoundDao roundDao;
    @Autowired
    private CourseClassDao courseClassDao;
    @Autowired
    private PresentationDao presentationDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private EmailService emailService;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        return seminarDao.getSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger courseId,Integer roundSerial) throws RepetitiveRecordException {
        if(roundSerial.equals(-1))
        {
            Round round = new Round();
            roundSerial=roundDao.getMaxRoundSerialByCourseId(courseId);
            if(null==roundSerial){
                roundSerial=0;
            }
            roundSerial++;
            round.setRoundSerial(roundSerial);
            roundDao.insertRound(round,courseId);
        }
        Round round=roundDao.getRoundByCourseIdAndRoundSerial(courseId,roundSerial);
        BigInteger roundId=round.getId();
        seminarDao.insertSeminarInfo(seminarInfo,roundId,courseId);
        seminarInfo = seminarDao.getSeminarInfoBySeminarNameAndCourseId(seminarInfo.getSeminarName(),courseId);
        List<CourseClass>courseClassList = courseClassDao.getCourseClassByCourseId(courseId);
        for(CourseClass courseClass:courseClassList){
            SeminarControl seminarControl = new SeminarControl();
            seminarDao.insertSeminarControl(seminarControl,courseClass.getId(),seminarInfo.getId());
        }
        List<Course> subCourseList=courseDao.getCourseBySeminarMainCourseId(courseId);
        if(subCourseList!=null){
            for(Course course:subCourseList){
                insertSeminarInfoToSubCourse(seminarInfo,course.getId(),roundSerial);
            }
        }
    }

    private void insertSeminarInfoToSubCourse(SeminarInfo seminarInfo,BigInteger courseId,Integer roundSerial) {
        Integer maxRoundSerial=roundDao.getMaxRoundSerialByCourseId(courseId);
        if(null==maxRoundSerial){
            Round round = new Round();
            round.setRoundSerial(roundSerial);
            roundDao.insertRound(round,courseId);
        }
        else if(!maxRoundSerial.equals(roundSerial)) {
            Round round = new Round();
            roundSerial = roundDao.getMaxRoundSerialByCourseId(courseId);
            if(null==roundSerial){
                roundSerial=0;
            }
            roundSerial+= 1;
            round.setRoundSerial(roundSerial);
            roundDao.insertRound(round,courseId);
        }
        Round round=roundDao.getRoundByCourseIdAndRoundSerial(courseId,roundSerial);
        BigInteger roundId=round.getId();
        seminarDao.insertSeminarInfo(seminarInfo,roundId,courseId);
        seminarInfo = seminarDao.getSeminarInfoBySeminarNameAndCourseId(seminarInfo.getSeminarName(),courseId);
        List<CourseClass>courseClassList = courseClassDao.getCourseClassByCourseId(courseId);
        for(CourseClass courseClass:courseClassList){
            SeminarControl seminarControl = new SeminarControl();
            seminarDao.insertSeminarControl(seminarControl,courseClass.getId(),seminarInfo.getId());
        }
}

    @Override
    public void updateSeminarInfoBySeminarInfoId(SeminarInfo seminarInfo,BigInteger roundId) throws SeminarInfoNotFoundException {
        seminarDao.updateSeminarInfo(seminarInfo,roundId);
    }

    @Override
    public SeminarControl getSeminarControlBySeminarControlId(BigInteger seminarControlId)
    {
        return seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
    }

    @Override
    public List<SeminarScore> getSeminarScoreBySeminarControlId(BigInteger seminarControlId){
        return seminarDao.getSeminarScoreBySeminarControlId(seminarControlId);
    }

    @Override
    public SeminarScore getSeminarScoreBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId){
        return seminarDao.getSeminarScoreBySeminarControlIdAndTeamId(seminarControlId,teamId);
    }

    @Override
    public void deleteSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        seminarDao.deleteSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public SeminarControl getSeminarControlByClassIdAndSeminarInfoId(BigInteger classId, BigInteger seminarInfoId) throws SeminarControlNotFoundException {
        return seminarDao.getSeminarControlByClassIdAndSeminarInfo(classId,seminarInfoId);
    }

    @Override
    public List<SeminarInfo> getSeminarInfoByRoundId(BigInteger roundId){
        return seminarDao.getSeminarInfoByRoundId(roundId);
    }

    @Override
    public List<List<SeminarInfo>> getSeminarInfoByRoundList(List<Round> roundList) {
        List<List<SeminarInfo>> SeminarInfoOrderByRoundId= new ArrayList<List<SeminarInfo>>();
        List<SeminarInfo> temp;
        for(int i=0;i<roundList.size();i++)
        {
            temp=getSeminarInfoByRoundId(roundList.get(i).getId());
            SeminarInfoOrderByRoundId.add(i,temp);
        }
        return SeminarInfoOrderByRoundId;
    }

    @Override
    public void insertPresentation(int teamOrder,BigInteger seminarControlId, BigInteger teamId) throws HaveEnrollException{
        Presentation presentation = new Presentation();
        presentation.setTeamOrder(teamOrder);
        if(presentationDao.getPresentationBySeminarControlIdAndTeamOrder(seminarControlId,teamOrder)!=null)
        {
            throw new HaveEnrollException();
        }
        presentationDao.deletePresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentationDao.insertPresentation(presentation,seminarControlId,teamId);
    }

    @Override
    public void updateSeminarControl(SeminarControl seminarControl) {
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public void upLoadPPT(HttpServletRequest request,MultipartFile multipartFile,BigInteger seminarControlId,BigInteger teamId) throws IOException {
        File file=saveFile(request,multipartFile,seminarControlId,teamId,"PPT");
        Presentation presentation=presentationDao.getPresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentation.setPptName(multipartFile.getOriginalFilename());
        presentation.setPptUrl(file.getParentFile().getAbsolutePath());
        presentationDao.updatePresentation(presentation);
    }

    @Override
    public void upLoadReport(HttpServletRequest request,MultipartFile multipartFile,BigInteger seminarControlId,BigInteger teamId) throws IOException {
        File file=saveFile(request,multipartFile,seminarControlId,teamId,"Report");
        Presentation presentation=presentationDao.getPresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentation.setReportName(multipartFile.getOriginalFilename());
        presentation.setReportUrl(file.getParentFile().getAbsolutePath());
        presentationDao.updatePresentation(presentation);
    }
    private File saveFile(HttpServletRequest request, MultipartFile multipartFile, BigInteger seminarControlId, BigInteger teamId, String type) throws IOException {
        String path= request.getSession().getServletContext().getRealPath("/");
        File tmpfile = new File(path);
        tmpfile=tmpfile.getParentFile();
        File file=new File(tmpfile.getPath()+"File"+ File.separator+seminarControlId.toString()+File.separator+teamId.toString()+File.separator+type+File.separator+multipartFile.getOriginalFilename());
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        multipartFile.transferTo(file);
        return file;
    }

    @Override
    public void updateShareSeminarApplication(ShareSeminarApplication shareSeminarApplication){
        Teacher teacher=teacherDao.getTeacherByTeacherId(shareSeminarApplication.getSubCourse().getTeacherId());
        String to=teacher.getEmail();
        String subject="共享组队请求反馈";
        String text="";
        //同意请求，编辑同意邮件
        if(shareSeminarApplication.getStatus()==1){
            //更新从课程的主课程id
            courseDao.updateCourseSeminarMainCourseId(shareSeminarApplication.getSubCourse().getId(),shareSeminarApplication.getMainCourse().getId());
            //删除从课程原有讨论课
            List<Round> originalRoundList=roundDao.getRoundByCourseId(shareSeminarApplication.getSubCourse().getId());
            if(null!=originalRoundList){
                for(Round round:originalRoundList) {
                    seminarDao.deleteSeminarControlByRoundId(round.getId());
                    seminarDao.deleteSeminarInfoByRoundId(round.getId());
                    roundDao.deleteRoundByRoundId(round.getId());
                }
            }
            //向从课程插入主课程下的讨论课
            Course mainCourse=courseDao.getCourseByCourseId(shareSeminarApplication.getMainCourse().getId());
            List<Round> roundList=mainCourse.getRoundList();
            for(Round round:roundList){
                Integer roundSerial=round.getRoundSerial();
                for(SeminarInfo seminarInfo:round.getSeminarInfoList()){
                    insertSeminarInfoToSubCourse(seminarInfo,shareSeminarApplication.getSubCourse().getId(),roundSerial);
                }
            }
            text=text+teacher.getTeacherName()+"同意了您对"+shareSeminarApplication.getMainCourse().getCourseName()+"课程的共享讨论课请求";
        }
        //拒绝请求，编辑拒绝邮件
        else{
            text=text+teacher.getTeacherName()+"拒绝了您对"+shareSeminarApplication.getMainCourse().getCourseName()+"课程的共享讨论课请求";
        }
        //发送邮件，删除共享请求
        emailService.sendSimpleMessage(to,subject,text);
        courseDao.deleteShareTeamApplication(shareSeminarApplication.getId());
    }

    @Override
    public void deletePresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId) {
        presentationDao.deletePresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
    }

    @Override
    public void cancelSeminarShare(Course subCourse){
        //取消讨论课共享，删除讨论课
        List<Round> originalRoundList=roundDao.getRoundByCourseId(subCourse.getId());
        for(Round round:originalRoundList) {
            seminarDao.deleteSeminarControlByRoundId(round.getId());
            seminarDao.deleteSeminarInfoByRoundId(round.getId());
            roundDao.deleteRoundByRoundId(round.getId());
        }
        courseDao.updateCourseTeamMainCourseId(subCourse.getId(),null);
    }

    private void updateRoundScore(BigInteger roundId,BigInteger teamId){
        RoundScore roundScore=roundDao.getRoundScoreByRoundIdAndTeamId(roundId,teamId);
        //若本轮分数尚无记录，插入记录并重新获取包含讨论课分数的轮次分数
        if(null==roundScore){
            roundScore=new RoundScore();
            roundDao.insertRoundScore(roundScore);
            roundScore=roundDao.getRoundScoreByRoundIdAndTeamId(roundId,teamId);
        }
        List<SeminarScore> seminarScoreList=roundScore.getSeminarScoreList();
        Round round=roundDao.getRoundByRoundId(roundId);
        Course course=courseDao.getCourseByRoundId(roundId);
        List<Double> questionScore=new ArrayList();

        for(SeminarScore seminarScore:seminarScoreList){
            questionScore.add(seminarScore.getQuestionScore());
        }

        updatePresentationScoreForRoundScore(roundScore,round,seminarScoreList,teamId);
        updateQuestionScoreForRoundScore(roundScore,round,seminarScoreList);
        updateReportScoreForRoundScore(roundScore,round,seminarScoreList,teamId);

        roundScore.setTotalScore(course.getPresentationPercentage()*roundScore.getPresentationScore()+course.getQuestionPercentage()*roundScore.getQuestionScore()+course.getReportPercentage()*roundScore.getReportScore());
        roundDao.updateRoundScore(roundScore,roundId,teamId);
    }

    private void updatePresentationScoreForRoundScore(RoundScore roundScore, Round round, List<SeminarScore> seminarScoreList, BigInteger teamId){
        switch (round.getPresentationScoreMethod()){
            //平均分
            case 0: {
                Double sum=seminarScoreList.stream().mapToDouble(SeminarScore::getPresentationScore).sum();
                Integer enrollNumber=roundDao.getEnrollNumBycourseClassIdAndRoundId(teamDao.getTeamByTeamId(teamId).getCourseClass().getId(),round.getId());
                roundScore.setPresentationScore(sum/enrollNumber);
                break;
            }
            //最高分
            case 1: {
                Double presentation_score=seminarScoreList.stream().mapToDouble(SeminarScore::getPresentationScore).max().getAsDouble();
                if(presentation_score!=null) {
                    roundScore.setPresentationScore(presentation_score);
                }
                else{
                    roundScore.setPresentationScore(Double.valueOf(0));
                }
                break;
            }
            default:
        }
    }

    private void updateQuestionScoreForRoundScore(RoundScore roundScore,Round round,List<SeminarScore>seminarScoreList){
        switch (round.getQuestionScoreMethod()){
            //平均分
            case 0: {
                int count=0;
                Double sum=Double.valueOf(0);
                for(int i=0;i<seminarScoreList.size();i++){
                    Double question_score=seminarScoreList.get(i).getQuestionScore();
                    if(question_score!=null){
                        sum+=question_score;
                        count++;
                    }
                }
                if(count!=0) {
                    roundScore.setQuestionScore(sum / count);
                }
                else{
                    roundScore.setQuestionScore(Double.valueOf(0));
                }
                break;
            }
            //最高分
            case 1: {
                Double question_score=seminarScoreList.stream().mapToDouble(SeminarScore::getQuestionScore).max().getAsDouble();
                if(question_score!=null) {
                    roundScore.setQuestionScore(question_score);
                }
                else{
                    roundScore.setQuestionScore(Double.valueOf(0));
                }
                break;
            }
            default:
        }
    }

    private void updateReportScoreForRoundScore(RoundScore roundScore, Round round, List<SeminarScore> seminarScoreList, BigInteger teamId){
        switch (round.getReportScoreMethod()){
            //平均分
            case 0: {
                Double sum=seminarScoreList.stream().mapToDouble(SeminarScore::getReportScore).sum();
                Integer enrollNumber=roundDao.getEnrollNumBycourseClassIdAndRoundId(teamDao.getTeamByTeamId(teamId).getCourseClass().getId(),round.getId());
                roundScore.setReportScore(sum/enrollNumber);
                break;
            }
            case 1: {
                Double report_score=seminarScoreList.stream().mapToDouble(SeminarScore::getReportScore).max().getAsDouble();
                if(report_score!=null) {
                    roundScore.setReportScore(report_score);
                }
                else{
                    roundScore.setReportScore(Double.valueOf(0));
                }
                break;
            }
            default:
        }
    }

    @Override
    public void updateSeminarScore(Double presentationScore,Double questionScore,Double reportScore,BigInteger seminarControlId,BigInteger teamId){
        SeminarScore seminarScore=seminarDao.getSeminarScoreBySeminarControlIdAndTeamId(seminarControlId,teamId);
        SeminarControl seminarControl=seminarDao.getSeminarControlBySeminarControlId(seminarControlId);
        Course course=seminarControl.getCourseClass().getCourse();
        Double totalScore=course.getPresentationPercentage()*presentationScore+course.getQuestionPercentage()*questionScore+course.getReportPercentage()*reportScore;
        if(null==seminarScore){
            seminarScore=new SeminarScore();
            seminarScore.setPresentationScore(presentationScore);
            seminarScore.setQuestionScore(questionScore);
            seminarScore.setReportScore(reportScore);
            seminarScore.setTotalScore(totalScore);
            seminarDao.insertSeminarScore(seminarScore,seminarControlId,teamId);
        }
        else {
            seminarScore.setPresentationScore(presentationScore);
            seminarScore.setQuestionScore(questionScore);
            seminarScore.setReportScore(reportScore);
            seminarScore.setTotalScore(totalScore);
            seminarDao.updateSeminarScore(seminarScore, seminarControlId, teamId);
        }
        BigInteger roundId=roundDao.getRoundIdBySeminarControlId(seminarControlId);
        //更新该轮总分
        updateRoundScore(roundId,teamId);
    }

    @Override
    public void updateSeminarScoreForQuestion(Double questionScore,BigInteger seminarControlId,BigInteger teamId){
        SeminarScore seminarScore=seminarDao.getSeminarScoreBySeminarControlIdAndTeamId(seminarControlId,teamId);
        if(null==seminarScore){
            seminarScore=new SeminarScore();
            seminarScore.setQuestionScore(questionScore);
            seminarDao.insertSeminarScore(seminarScore,seminarControlId,teamId);
        }
        else {
            seminarScore.setQuestionScore(questionScore);
            seminarDao.updateSeminarScore(seminarScore, seminarControlId, teamId);
        }
        BigInteger roundId=roundDao.getRoundIdBySeminarControlId(seminarControlId);
        //更新该轮总分
        updateRoundScore(roundId,teamId);
    }

    @Override
    public void updateQuestionScore(BigInteger questionId, Double score) {
        Question question = questionDao.getQuestionByQuestionId(questionId);
        SeminarScore seminarScore = seminarDao.getSeminarScoreBySeminarControlIdAndTeamId(question.getSeminarControlId(), question.getTeamId());
        if (null == seminarScore) {
            seminarScore = new SeminarScore();
            seminarScore.setQuestionScore(score);
            seminarDao.insertSeminarScore(seminarScore, question.getSeminarControlId(), question.getTeamId());
        } else {
            seminarScore.setQuestionScore(score);
            seminarDao.updateSeminarScore(seminarScore, question.getSeminarControlId(), question.getTeamId());
        }
    }

    @Override
    public void updatePresentationScore(BigInteger presentationId, Double score) {
        Presentation presentation=presentationDao.getPresentationByPresentationId(presentationId);
        SeminarScore seminarScore=seminarDao.getSeminarScoreBySeminarControlIdAndTeamId(presentation.getSeminarControlId(),presentation.getTeam().getId());
        if(null==seminarScore){
            seminarScore=new SeminarScore();
            seminarScore.setPresentationScore(score);
            seminarDao.insertSeminarScore(seminarScore,presentation.getSeminarControlId(),presentation.getTeam().getId());
        }
        else{
        seminarScore.setPresentationScore(score);
        seminarDao.updateSeminarScore(seminarScore,presentation.getSeminarControlId(),presentation.getTeam().getId());
        }
    }
}
