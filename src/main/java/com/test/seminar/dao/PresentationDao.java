package com.test.seminar.dao;

<<<<<<< HEAD
import com.test.seminar.entity.Team;
import com.test.seminar.mapper.PresentationMapper;
import org.springframework.beans.factory.annotation.Autowired;

=======
import com.test.seminar.entity.Presentation;

import java.math.BigInteger;
>>>>>>> bf0f78b815a0cbdeebec6b568c74f5ff90aa8d7a
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

<<<<<<< HEAD
=======
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
>>>>>>> bf0f78b815a0cbdeebec6b568c74f5ff90aa8d7a
}
