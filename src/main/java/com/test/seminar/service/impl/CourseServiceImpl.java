package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.service.CourseService;
import com.test.seminar.entity.strategy.TeamStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TeamDao teamDao;

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        return courseDao.getCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseDao.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseDao.getCourseByStudentId(studentId);
    }

    @Override
    public void insertCourse(Course course, BigInteger teacherId) throws RepetitiveRecordException {
        courseDao.insertCourse(course, teacherId);
    }

    @Override
    public void updateCourseByCourseId(Course course) throws CourseNotFoundException {
        courseDao.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        courseDao.deleteCourseByCourseId(courseId);
    }

    /**
     * @author wzw
     * date 2018/12/25
     */
    @Override
    public Boolean isTeamValid(BigInteger teamId) throws TeamNotFoundException {
        //获取队伍
        Team team = teamDao.getTeamByTeamId(teamId);

        //获取队伍总策略
        List<TeamStrategy> teamStrategyList = courseDao.getTeamStrategyListByCourseId(team.getCourse().getId());

        //遍历每一个策略
        for (TeamStrategy teamStrategy : teamStrategyList) {
            //获得策略类名
            String strategyName = teamStrategy.getStrategyName();
            try {
                //判断该策略是否为复合策略
                Class strategyClass = Class.forName(strategyName);
                Boolean isCompositStrategy = CompositStrategy.class.isAssignableFrom(strategyClass);

                Boolean result = null;
                if (isCompositStrategy) {
                    //复合策略验证
                    result = courseDao.validCompositStrategyOnTeam(team, teamStrategy.getStrategyId(), strategyName);
                } else {
                    //简单策略验证
                    result = courseDao.validSimpleStrategyOnTeam(team, teamStrategy.getStrategyId(), strategyName);
                }

                //只要有一个策略没满足，就返回false
                if (!result) {
                    return false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //所有策略都满足，返回true
        return true;
    }
}
