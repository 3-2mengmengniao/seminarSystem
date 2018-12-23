package com.test.seminar.service.impl;

import com.test.seminar.dao.PresentationDao;
import com.test.seminar.dao.SeminarDao;
import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.service.RundSeminarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RunSeminarServiceImpl implements RundSeminarService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    PresentationDao presentationDao;
    @Override
    public void beginSeminar(SeminarControl seminarControl) {
        seminarControl.setSeminarStatus(1);
        List<Presentation> presentationList=seminarControl.getPresentationList();
        for(Presentation presentation:presentationList){
            if(presentation!=null){
                presentation.setPresent(1);
                presentationDao.updatePresentation(presentation);
                break;
            }
        }
        seminarDao.updateSeminarControl(seminarControl);
    }

    @Override
    public void endSeminar(SeminarControl seminarControl) {
        seminarControl.setSeminarStatus(2);
        seminarDao.updateSeminarControl(seminarControl);
    }
}
