package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.entity.StrategyPair;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.ShareTeamApplicationNotFoundException;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.entity.strategy.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class CourseDaoImpl implements CourseDao {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseDao courseDao;

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseMapper.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseMapper.getCourseByStudentId(studentId);
    }

    @Override
    public List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId) {
        return courseMapper.getCourseBySeminarMainCourseId(seminarMainCourseId);
    }

    @Override
    public List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId) {
        return courseMapper.getCourseByTeamMainCourseId(teamMainCourseId);
    }

    @Override
    public void insertCourse(Course course, BigInteger teacherId) throws RepetitiveRecordException {
        courseMapper.insertCourse(course, teacherId);
    }

    @Override
    public void updateCourseByCourseId(Course course) throws CourseNotFoundException {
        courseMapper.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        courseMapper.deleteCourseByCourseId(courseId);
    }

    @Override
    public List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId) throws StrategyNotFoundException {
        List<TeamStrategy> teamStrategyList = courseMapper.getTeamStrategyListByCourseId(courseId);
        if (teamStrategyList == null) {
            throw new StrategyNotFoundException();
        }
        return teamStrategyList;
    }

    @Override
    public MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        MemberLimitStrategy memberLimitStrategy = courseMapper.getMemberLimitStrategyByStrategyId(strategyId);
        if (memberLimitStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return memberLimitStrategy;
    }

    @Override
    public void updateMemberLimitStrategy(MemberLimitStrategy memberLimitStrategy) {
        courseMapper.updateMemberLimitStrategy(memberLimitStrategy);
    }

    @Override
    public void deleteMemberLimitStrategyByStrategyId(BigInteger strategyId) {
        courseMapper.deleteMemberLimitStrategyByStrategyId(strategyId);
    }

    @Override
    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        CourseMemberLimitStrategy courseMemberLimitStrategy = courseMapper.getCourseMemberLimitStrategyByStrategyId(strategyId);
        if (courseMemberLimitStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return courseMemberLimitStrategy;
    }

    @Override
    public ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        ConflictCourseStrategy conflictCourseStrategy = courseMapper.getConflictCourseStrategyByStrategyId(strategyId);
        if (conflictCourseStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return conflictCourseStrategy;
    }

    @Override
    public TeamAndStrategy getTeamAndStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        TeamAndStrategy teamAndStrategy = courseMapper.getTeamAndStrategyByStrategyId(strategyId);
        if (teamAndStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return teamAndStrategy;
    }

    @Override
    public TeamOrStrategy getTeamOrStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        TeamOrStrategy teamOrStrategy = courseMapper.getTeamOrStrategyByStrategyId(strategyId);
        if (teamOrStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return teamOrStrategy;
    }

    @Override
    public Boolean validSimpleStrategyOnTeam(Team team, BigInteger strategyId, String strategyName) throws StrategyNotFoundException {
        try {
            //用反射得到获取特定策略的dao层方法
            String courseDaoMethodName = "get" + strategyName + "ByStrategyId";
            Method courseDaoMethod = CourseDao.class.getMethod(courseDaoMethodName, BigInteger.class);

            //得到特定策略的对象
            Object strategy = courseDaoMethod.invoke(courseDao, strategyId);

            //得到特定策略类的isValid方法
            Class strategyClass = Class.forName(strategyName);
            Method isValid = strategyClass.getMethod("isValid", Team.class);

            //调用特定策略类的isValid方法
            Object result = isValid.invoke(strategy, team);

            return (Boolean) result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //异常
        return null;
    }

    @Override
    public Boolean validCompositStrategyOnTeam(Team team, BigInteger strategyId, String strategyName) throws StrategyNotFoundException {
        String TeamAndStrategy = "TeamAndStrategy";
        String TeamOrStrategy = "TeamOrStrategy";

        try {
            //用反射得到获取复合策略的dao层方法
            String courseDaoMethodName = "getCompositStrategyByStrategyId";
            Method courseDaoMethod = CourseDao.class.getMethod(courseDaoMethodName, BigInteger.class);

            //得到复合策略的对象
            CompositStrategy compositStrategy = (CompositStrategy)courseDaoMethod.invoke(courseDao, strategyId);

            //得到复合策略中的策略列表
            List<StrategyPair> strategyNameAndIdList=compositStrategy.getStrategyNameAndIdList();

            //遍历每一个策略
            for (StrategyPair strategyPair : strategyNameAndIdList) {
                String name = strategyPair.getStrategyName();
                BigInteger id=strategyPair.getStrategyId();

                //判断该策略是否为复合策略
                Class strategyClass = Class.forName(name);
                Boolean isCompositStrategy = CompositStrategy.class.isAssignableFrom(strategyClass);

                Boolean result;
                if (isCompositStrategy) {
                    //复合策略验证
                    result = courseDao.validCompositStrategyOnTeam(team, id, name);
                } else {
                    //简单策略验证
                    result = courseDao.validSimpleStrategyOnTeam(team, id, name);
                }

                //根据复合策略的类型判断
                if (TeamAndStrategy.equals(strategyName)) {
                    //如果是and则一个策略不满足就返回false
                    if (!result) {
                        return false;
                    }
                } else if (TeamOrStrategy.equals(strategyName)) {
                    //如果是or则一个策略满足就返回true
                    if (result) {
                        return true;
                    }
                }
            }

            //遍历完所有策略后，根据复合策略的类型判断
            if (TeamAndStrategy.equals(strategyName)) {
                //如果是and且所有策略都符合返回true
                return true;

            } else if (TeamOrStrategy.equals(strategyName)) {
                //如果是or且所有策略都不符合返回false
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //异常
        return null;
    }

    @Override
    public CompositStrategy getCompositStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        return null;
    }

    @Override
    public void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId) {
        courseMapper.insertShareTeamApplication(mainCourseId,subCourseId,subCourseTeacherId);
    }

    @Override
    public void deleteShareTeamApplication(BigInteger shareTeamApplicationId) {
        courseMapper.deleteShareTeamApplication(shareTeamApplicationId);
    }

    @Override
    public ShareTeamApplication getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId) throws ShareTeamApplicationNotFoundException {
        ShareTeamApplication shareTeamApplication=courseMapper.getShareTeamApplicationBySubCourseTeacherId(subCourseTeacherId);
        if(shareTeamApplication==null){
            throw new ShareTeamApplicationNotFoundException();
        }
        return shareTeamApplication;
    }

    @Override
    public void createShareTeamAssociation(ShareTeamApplication shareTeamApplication) {
        BigInteger subCourseId=shareTeamApplication.getSubCourse().getId();
        BigInteger mainCourseId=shareTeamApplication.getMainCourse().getId();
        courseMapper.updateCourseTeamMainCourseId(subCourseId,mainCourseId);
    }
}