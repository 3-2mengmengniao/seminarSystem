package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.PresentationDao;
import com.test.seminar.dao.RoundDao;
import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.*;
import com.test.seminar.exception.HaveEnrollException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.exception.SeminarInfoNotFoundException;
import com.test.seminar.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public SeminarInfo getSeminarInfoBySeminarInfoId(BigInteger seminarInfoId) throws SeminarInfoNotFoundException {
        return seminarDao.getSeminarInfoBySeminarInfoId(seminarInfoId);
    }

    @Override
    public void insertSeminarInfo(SeminarInfo seminarInfo,BigInteger courseId,BigInteger roundId) throws RepetitiveRecordException {
        if(roundId.equals(new BigInteger("-1")))
        {
            Round round = new Round();
            round.setRoundSerial(roundDao.getMaxRoundSerialByCourseId(courseId)+1);
            roundDao.insertRound(round,courseId);
            round=roundDao.getRoundByCourseIdAndRoundSerial(courseId,round.getRoundSerial());
            roundId=round.getId();
        }
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
            throw new HaveEnrollException();
        presentationDao.deletePresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentationDao.insertPresentation(presentation,seminarControlId,teamId);
    }

    @Override
    public void updateSeminarControl(SeminarControl seminarControl) {
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public void upLoadPPT(MultipartFile multipartFile,BigInteger seminarControlId,BigInteger teamId) throws IOException {
        File file=saveFile(multipartFile,seminarControlId,teamId,"PPT");
        Presentation presentation=presentationDao.getPresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentation.setPptName(multipartFile.getOriginalFilename());
        presentation.setPptUrl(file.getParentFile().getAbsolutePath());
        presentationDao.updatePresentation(presentation);
    }

    @Override
    public void upLoadReport(MultipartFile multipartFile,BigInteger seminarControlId,BigInteger teamId) throws IOException {
        File file=saveFile(multipartFile,seminarControlId,teamId,"Report");
        Presentation presentation=presentationDao.getPresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
        presentation.setReportName(multipartFile.getOriginalFilename());
        presentation.setReportUrl(file.getParentFile().getAbsolutePath());
        presentationDao.updatePresentation(presentation);
    }
    private File saveFile(MultipartFile multipartFile,BigInteger seminarControlId,BigInteger teamId,String type) throws IOException {
        String path=System.getProperty("user.dir");
        File tmpfile = new File(path);
        tmpfile=tmpfile.getParentFile();
        File file=new File(tmpfile.getPath()+File.separator+"File"+ File.separator+seminarControlId.toString()+File.separator+teamId.toString()+File.separator+type+File.separator+multipartFile.getOriginalFilename());
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        multipartFile.transferTo(file);
        return file;
    }
}
