package com.test.seminar.dao.impl;

import com.test.seminar.dao.PresentationDao;
import com.test.seminar.mapper.PresentationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class PresentationDaoImpl implements PresentationDao {
    @Autowired
    PresentationMapper presentationMapper;
}
