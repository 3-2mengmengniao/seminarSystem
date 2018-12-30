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

    /**
     * 通过班级讨论课获取展示序列
     *
     * @param seminarControlId seminar control id
     * @return List<Presentation>
     */
    List<Presentation> getPresentationBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 插入展示
     *
     * @param presentation presentation
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void insertPresentation(@Param("presentation")Presentation presentation, @Param("seminarControlId") BigInteger seminarControlId, @Param("teamId")BigInteger teamId);

    /**
     * 更新展示
     *
     * @param presentation presentation
     */
    void updatePresentation(@Param("presentation")Presentation presentation);

    /**
     * 通过id删除展示
     *
     * @param presentationId presentation id
     */
    void deletePresentationByPresentationId(@Param("presentationId")BigInteger presentationId);

    /**
     * 通过班级讨论课和小组顺序获取展示
     *
     * @param seminarControlId seminar control id
     * @param teamOrder team oreder
     * @return presentation
     */
    Presentation getPresentationBySeminarControlIdAndTeamOrder(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamOrder")int teamOrder);

    /**
     * 通过班级讨论课和小组id获取展示
     *
     * @param seminarControlId semianr control id
     * @param teamId team id
     * @return presentation
     */
    Presentation getPresentationBySeminarControlIdAndTeamId(@Param("seminarControlId")BigInteger seminarControlId,@Param("teamId")BigInteger teamId);

    /**
     * 通过班级讨论课和小组顺序删除展示
     *
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void deletePresentationBySeminarControlIdAndTeamId(@Param("seminarControlId") BigInteger seminarControlId,@Param("teamId") BigInteger teamId);

    /**
     * 通过id获取展示
     *
     * @param presentationId presentation id
     * @return presentation
     */
    Presentation getPresentationByPresentationId(@Param("presentationId")BigInteger presentationId);
}
