package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
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
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private CourseMapper courseMapper;
}
