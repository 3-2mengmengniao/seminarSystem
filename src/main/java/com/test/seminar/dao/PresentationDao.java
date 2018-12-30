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
     * 通过发言顺序和班级讨论课获取展示
     *
     * @param seminarControlId seminar control id
     * @param teamOrder team order
     * @return Presentation
     */
    Presentation getPresentationBySeminarControlIdAndTeamOrder(BigInteger seminarControlId, int teamOrder);

    /**
     * 通过小组和班级讨论课获取展示序列
     *
     * @param seminarControlId seminar control id
     * @param teamId team id
     * @return Presentation
     */
    Presentation getPresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId, BigInteger teamId);

    /**
     * 插入展示
     *
     * @param presentation Presentation
     * @param teamId team id
     * @param seminarControlId seminar control id
     */
    void insertPresentation(Presentation presentation, BigInteger seminarControlId,BigInteger teamId);

    /**
     * 更新展示
     *
     * @param presentation Presentation
     */
    void updatePresentation(Presentation presentation);

    /**
     * 通过id删除展示
     *
     * @param presentationId Presentation id
     */
    void deletePresentationByPresentationId(BigInteger presentationId);

    /**
     * 通过共享讨论课和小组删除展示
     *
     * @param seminarControlId seminar control id
     * @param teamId team id
     */
    void deletePresentationBySeminarControlIdAndTeamId(BigInteger seminarControlId,BigInteger teamId);

    /**
     * 通过展示id获取展示
     *
     * @param presentationId Presentation id
     * @return Presentation
     */
    Presentation getPresentationByPresentationId(BigInteger presentationId);

}
