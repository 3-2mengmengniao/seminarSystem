package com.test.seminar.dao;
import com.test.seminar.entity.Presentation;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface PresentationDao {

    Presentation getPresentationByTeamOrder(int teamOrder);
    /**
     *
     * @param presentation
     * @param teamId
     * @param seminarControlId
     */
    void insertPresentation(Presentation presentation, BigInteger seminarControlId,BigInteger teamId);

    /**
     *
     * @param presentation
     */
    void updatePresentation(Presentation presentation);

    /**
     *
     * @param presentationId
     */
    void deletePresentationByPresentationId(BigInteger presentationId);

    void deletePresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);
}
