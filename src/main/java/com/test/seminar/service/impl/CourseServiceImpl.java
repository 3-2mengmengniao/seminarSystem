package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Team;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.service.CourseService;
import com.test.seminar.strategy.Strategy;
import com.test.seminar.strategy.impl.TeamStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
                //用反射得到获取特定策略的dao层方法
                String courseDaoMethodName = "get" + strategyName + "ByStrategyId";
                Method courseDaoMethod = CourseDao.class.getMethod(courseDaoMethodName, BigInteger.class);
                //得到特定策略的对象
                Object strategy = courseDaoMethod.invoke(courseDao, teamStrategy.getStrategyId());
                //得到特定策略类的isValid方法
                Class strategyClass = Class.forName(strategyName);
                Method isValid = strategyClass.getMethod("isValid", Team.class);
                //调用特定策略类的isValid方法
                Object result = isValid.invoke(strategy, team);
                //只要有一个策略没满足，就返回false
                if (!(Boolean) result) {
                    return false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
