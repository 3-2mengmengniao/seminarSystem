package com.test.seminar.dao;

import com.test.seminar.entity.Presentation;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface PresentationDao {
    /**
     *
     * @param seminarControlId
     * @return
     */
    List<Presentation> getPresentationBySeminarControlId(BigInteger seminarControlId);

    /**
     *
     * @param presentation
     * @param courseClassId
     * @param seminarControlId
     */
    void insertPresentation(Presentation presentation, BigInteger courseClassId,BigInteger seminarControlId);

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
}
