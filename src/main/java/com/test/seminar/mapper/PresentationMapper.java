package com.test.seminar.mapper;

import com.test.seminar.entity.Presentation;
import com.test.seminar.entity.SeminarControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author cxh
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface PresentationMapper {

    List<Presentation> getPresentationBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    void insertPresentation(@Param("presentation")Presentation presentation, @Param("seminarControlId") BigInteger seminarControlId, @Param("teamId")BigInteger teamId);

    void updatePresentation(@Param("presentation")Presentation presentation);

    void deletePresentationByPresentationId(@Param("presentationId")BigInteger presentationId);

    Presentation getPresentationBySeminarControlIdAndTeamOrder(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamOrder")int teamOrder);

    Presentation getPresentationBySeminarControlIdAndTeamId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    void deletePresentationBySeminarControlIdAndTeamId(@Param("seminarControlId") BigInteger seminarControlId,@Param("teamId") BigInteger teamId);

    Presentation getPresentationByPresentationId(@Param("presentationId")BigInteger presentationId);
}
