package com.test.seminar.dao;

import com.test.seminar.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/24
 *
 */
@Component
public class CourseDao {
    @Autowired
    private CourseMapper courseMapper;
}
