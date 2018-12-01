package com.test.seminar.mapper;

import com.test.seminar.entity.Round;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface RoundMapper {
    /**
     * 创建新轮次
     * @param round
     */
    void insertRound(@Param("round")Round round);

    /**
     * 删除轮次
     * @param roundId
     */
    void deleteRoundByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 更新轮次信息
     * @param round
     */
    void updateRound(@Param("round")BigInteger round);

    /**
     * 通过轮次ID获得轮次信息
     * @param roundId
     * @return
     */
    Round getRoundByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 根据课程ID获得本课程的所有轮次信息
     * @param courseId
     * @return
     */
    List<Round> getRoundByCourseId(@Param("courseId")BigInteger courseId);
}
