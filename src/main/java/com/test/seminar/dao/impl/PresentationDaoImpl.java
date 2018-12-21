package com.test.seminar.dao.impl;

import com.test.seminar.dao.PresentationDao;
import com.test.seminar.entity.Presentation;
import com.test.seminar.mapper.PresentationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class PresentationDaoImpl implements PresentationDao {
    @Autowired
    PresentationMapper presentationMapper;

    @Override
    public void insertPresentation(Presentation presentation, BigInteger courseClassId, BigInteger seminarControlId) {
        presentationMapper.insertPresentation(presentation,courseClassId,seminarControlId);
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        presentationMapper.updatePresentation(presentation);
    }

    @Override
    public void deletePresentationByPresentationId(BigInteger presentationId) {
        presentationMapper.deletePresentationByPresentationId(presentationId);
    }
}
