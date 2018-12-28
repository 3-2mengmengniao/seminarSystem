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
    private EmailService emailService;

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        return seminarDao.getSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger courseId,Integer roundSerial) throws RepetitiveRecordException {
        if(roundSerial.equals(-1))
        {
//            Round round = new Round();
//            round.setRoundSerial(roundDao.getMaxRoundSerialByCourseId(courseId)+1);
//            roundDao.insertRound(round,courseId);
//            round=roundDao.getRoundByCourseIdAndRoundSerial(courseId,round.getRoundSerial());
//            roundId=round.getId();
            Round round = new Round();
            roundSerial=roundDao.getMaxRoundSerialByCourseId(courseId)+1;
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

    private void insertSeminarInfoToSubCourse(SeminarInfo seminarInfo,BigInteger courseId,Integer roundSerial){
        Integer maxRoundSerial=roundDao.getMaxRoundSerialByCourseId(courseId);
        if(maxRoundSerial==null||!maxRoundSerial.equals(roundSerial))
        {
            Round round = new Round();
            if(!maxRoundSerial.equals(roundSerial)) {
                roundSerial = roundDao.getMaxRoundSerialByCourseId(courseId) + 1;
            }
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
    public void cancelSeminarShare(Course mainCourse,Course subCourse){
        //取消讨论课共享，删除讨论课
        List<Round> originalRoundList=roundDao.getRoundByCourseId(subCourse.getId());
        for(Round round:originalRoundList) {
            seminarDao.deleteSeminarControlByRoundId(round.getId());
            seminarDao.deleteSeminarInfoByRoundId(round.getId());
            roundDao.deleteRoundByRoundId(round.getId());
        }
        courseDao.updateCourseTeamMainCourseId(subCourse.getId(),null);

    }
}
