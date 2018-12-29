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
    private PresentationMapper presentationMapper;

    @Override
    public void insertPresentation(Presentation presentation, BigInteger seminarControlId,BigInteger teamId) {
        presentationMapper.insertPresentation(presentation,seminarControlId,teamId);
    }

    @Override
    public Presentation getPresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId) {
        return presentationMapper.getPresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        presentationMapper.updatePresentation(presentation);
    }

    @Override
    public void deletePresentationByPresentationId(BigInteger presentationId) {
        presentationMapper.deletePresentationByPresentationId(presentationId);
    }

    @Override
    public Presentation getPresentationBySeminarControlIdAndTeamOrder(BigInteger seminarControlId, int teamOrder) {
        return presentationMapper.getPresentationBySeminarControlIdAndTeamOrder(seminarControlId,teamOrder);
    }

    @Override
    public void deletePresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId) {
        presentationMapper.deletePresentationBySeminarControlIdAndTeamId(seminarControlId,teamId);
    }

    @Override
    public Presentation getPresentationByPresentationId(BigInteger presentationId) {
        return presentationMapper.getPresentationByPresentationId(presentationId);
    }
}
