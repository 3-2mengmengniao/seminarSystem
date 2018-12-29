package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
import com.test.seminar.entity.strategy.StrategyPair;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.mapper.StudentMapper;
import com.test.seminar.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class TeamDaoImpl implements TeamDao {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    private TeamDao teamDao;

    @Override
    public Team getTeamByTeamId(BigInteger teamId)throws TeamNotFoundException {
        Team team=teamMapper.getTeamByTeamId(teamId);
        if(team==null) {
            throw new TeamNotFoundException();
        }
        return team;
    }

    @Override
    public List<Team> getTeamByCourseId(BigInteger courseId) {
       BigInteger mainCourseId=courseMapper.getTeamMainCourseIdBySubCourseId(courseId);
       if(mainCourseId==null){
           return teamMapper.getTeamByCourseId(courseId);
       }
       else{
           return teamMapper.getTeamByCourseId(mainCourseId);
       }
    }

    @Override
    public List<Team> getTeamBySeminarControlId(BigInteger seminarControlId) {
       return teamMapper.getTeamBySeminarControlId(seminarControlId);
    }

    @Override
    public Team getTeamByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId){
        BigInteger mainCourseId=courseMapper.getTeamMainCourseIdBySubCourseId(courseId);
        if(mainCourseId==null){
            return teamMapper.getTeamByStudentIdAndCourseId(studentId,courseId);
        }
        else{
            return teamMapper.getTeamByStudentIdAndCourseId(studentId,mainCourseId);
        }
    }

    @Override
    public Serial getSerialByTeamId(BigInteger teamId) {
        return teamMapper.getSerialByTeamId(teamId);
    }

    @Override
    public void insertTeam(Team team, BigInteger courseClassId,BigInteger courseId)throws RepetitiveRecordException {
        teamMapper.insertTeam(team,courseClassId,courseId);
    }

    @Override
    public void insertCourseClassAndTeamRelation(BigInteger courseClassId, BigInteger teamId) {
        teamMapper.insertCourseClassAndTeamRelation(courseClassId,teamId);
    }

    @Override
    public void updateTeam(Team team)throws TeamNotFoundException {
        if(teamMapper.getTeamByTeamId(team.getId())==null) {
            throw new TeamNotFoundException();
        }
        teamMapper.updateTeam(team);
    }

    @Override
    public void updateCourseClassStudentTeamId(BigInteger courseClassId, BigInteger studentId, BigInteger teamId) {
        teamMapper.updateCourseClassStudentTeamId(courseClassId,studentId,teamId);
    }

    @Override
    public void deleteTeamByTeamId(BigInteger teamId)throws TeamNotFoundException {
        if(teamMapper.getTeamByTeamId(teamId)==null) {
            throw new TeamNotFoundException();
        }
        teamMapper.deleteTeamByTeamId(teamId);
    }

    @Override
    public List<TeamValidApplication> getTeamValidApplicationByTeacherId(BigInteger teacherId){
        return teamMapper.getTeamValidApplicationByTeacherId(teacherId);
    }

    @Override
    public TeamValidApplication getTeamValidApplicationByApplicationId(BigInteger applicationId){
        return  teamMapper.getTeamValidApplicationByApplicationId(applicationId);
    }

    @Override
    public void insetTeamStrategy(BigInteger courseId, List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse, Integer choose) {
        BigInteger id;
        for(ConflictCourseStrategy conflictCourseStrategy:conflictCourseStrategyArrayList){
            id=teamMapper.getMaxConflictCourseStrategyId().add(new BigInteger("1"));
            for(BigInteger conflictCourseId:conflictCourseStrategy.getConflictCourseIdList()){
                teamMapper.insertConflictCourseStrategy(id,conflictCourseId);
            }
            teamMapper.insertTeamStrategy(courseId,"ConflictCourseStrategy",id);
        }
        teamMapper.insertMemberLimitStrategy(thisCourse);
        id=teamMapper.getMaxTeamAndStrategyId().add(new BigInteger("1"));
        teamMapper.insertTeamAndStrategy(id,"MemberLimitStrategy",teamMapper.getMaxMemberLimitStrategyId());
        if(choose==0){
            BigInteger andId=teamMapper.getMaxTeamAndStrategyId().and(new BigInteger("1"));
            for(CourseMemberLimitStrategy courseMemberLimitStrategy:courseMemberLimitStrategyList){
                teamMapper.insertCourseMemberLimitStrategy(courseMemberLimitStrategy);
                teamMapper.insertTeamAndStrategy(andId,"CourseMemberLimitStrategy",teamMapper.getMaxCourseMemberLimitStrategyId());
            }
            teamMapper.insertTeamAndStrategy(id,"TeamAndStrategy",andId);
        }
        else {
            BigInteger orId=teamMapper.getMaxTeamOrStrategyId().and(new BigInteger("1"));
            for(CourseMemberLimitStrategy courseMemberLimitStrategy:courseMemberLimitStrategyList){
                teamMapper.insertCourseMemberLimitStrategy(courseMemberLimitStrategy);
                teamMapper.insertTeamAndStrategy(orId,"CourseMemberLimitStrategy",teamMapper.getMaxCourseMemberLimitStrategyId());
            }
            teamMapper.insertTeamAndStrategy(id,"TeamOrStrategy",orId);
        }
        teamMapper.insertTeamStrategy(courseId,"TeamAndStrategy",id);
    }

    @Override
    public void insertTeamValidApplication(TeamValidApplication teamValidApplication,BigInteger teamId,BigInteger teacherId){
        teamMapper.insertTeamValidApplication(teamValidApplication,teamId,teacherId);
    }

    @Override
    public void updateTeamValidApplication(TeamValidApplication teamValidApplication){
        teamMapper.updateTeamValidApplication(teamValidApplication);
    }

    @Override
    public void deleteTeamValidApplicationByTeamValidApplicationId(BigInteger teamValidApplicationId){
        teamMapper.deleteTeamValidApplicationByTeamValidApplicationId(teamValidApplicationId);
    }

    @Override
    public void deleteCourseClassAndTeamRelationByTeamId(BigInteger teamId) {
        teamMapper.deleteCourseClassAndTeamRelationByTeamId(teamId);
    }

    @Override
    public Team getTeamByMainCourseClassIdAndTeamSerial(BigInteger courseClassId, Integer teamSerial) {
        return teamMapper.getTeamByMainCourseClassIdAndTeamSerial(courseClassId,teamSerial);
    }

    @Override
    public void insertTeamAndStudentRelation(BigInteger teamId, BigInteger studentId) {
        teamMapper.insertTeamAndStudentRelation(teamId,studentId);
    }

    @Override
    public void deleteCourseClassAndTeamRelation(BigInteger teamId, BigInteger courseClassId) {
        teamMapper.deleteCourseClassAndTeamRelation(teamId,courseClassId);
    }

    @Override
    public void deleteTeamAndStudentRelation(BigInteger teamId, BigInteger studentId) {
        teamMapper.deleteTeamAndStudentRelation(teamId,studentId);
    }

    @Override
    public void deleteTeamAndStudentRelationByTeamId(BigInteger teamId) {
        teamMapper.deleteTeamAndStudentRelationByTeamId(teamId);
    }

    @Override
    public Integer getMaxTeamSerialByCourseClassId(BigInteger courseClassId) {
        return teamMapper.getMaxTeamSerialByCourseClassId(courseClassId);
    }

    @Override
    public List<Team> getGroupStudentByCourseId(BigInteger courseId) {
        return teamMapper.getGroupStudentByCourseId(courseId);
    }

    @Override
    public List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId) throws StrategyNotFoundException {
        List<TeamStrategy> teamStrategyList = teamMapper.getTeamStrategyListByCourseId(courseId);
        if (teamStrategyList == null) {
            throw new StrategyNotFoundException();
        }
        return teamStrategyList;
    }

    @Override
    public MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        MemberLimitStrategy memberLimitStrategy = teamMapper.getMemberLimitStrategyByStrategyId(strategyId);
        if (memberLimitStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return memberLimitStrategy;
    }

    @Override
    public void deleteMemberLimitStrategyByStrategyId(BigInteger strategyId) {
        teamMapper.deleteMemberLimitStrategyByStrategyId(strategyId);
    }

    @Override
    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        CourseMemberLimitStrategy courseMemberLimitStrategy = teamMapper.getCourseMemberLimitStrategyByStrategyId(strategyId);
        if (courseMemberLimitStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return courseMemberLimitStrategy;
    }

    @Override
    public ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        ConflictCourseStrategy conflictCourseStrategy=new ConflictCourseStrategy();
        conflictCourseStrategy.setConflictCourseIdList(teamMapper.getCourseIdByConflictCourseStrategyId(strategyId));
        if (conflictCourseStrategy == null) {
            throw new StrategyNotFoundException();
        }
        return conflictCourseStrategy;
    }

    @Override
    public Boolean validSimpleStrategyOnTeam(Team team, BigInteger strategyId, String strategyName) throws StrategyNotFoundException {
        try {
            //用反射得到获取特定策略的dao层方法
            String teamDaoMethodName = "get" + strategyName + "ByStrategyId";
            Method teamDaoMethod = TeamDao.class.getMethod(teamDaoMethodName, BigInteger.class);

            //得到特定策略的对象
            Object strategy = teamDaoMethod.invoke(teamDao, strategyId);

            //得到特定策略类的isValid方法
            Class strategyClass = Class.forName("com.test.seminar.entity.strategy.impl."+strategyName);
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

        try {
            //用反射得到获取复合策略的dao层方法
            String teamDaoMethodName = "getCompositStrategyByStrategyId";
            Method teamDaoMethod = TeamDao.class.getMethod(teamDaoMethodName, BigInteger.class,String.class);

            //得到复合策略的对象
            CompositStrategy compositStrategy = (CompositStrategy)teamDaoMethod.invoke(teamDao, strategyId, strategyName);

            //得到复合策略中的策略列表
            List<StrategyPair> strategyNameAndIdList=compositStrategy.getStrategyNameAndIdList();

            //遍历每一个策略
            for (StrategyPair strategyPair : strategyNameAndIdList) {
                String name = strategyPair.getStrategyName();
                BigInteger id=strategyPair.getStrategyId();

                //判断该策略是否为复合策略
                Boolean isCompositStrategy = false;
                String andValue="TeamAndStrategy";
                String orValue="TeamOrStrategy";

                if(andValue.equals(name)||orValue.equals(name)){
                    isCompositStrategy=true;
                }

                Boolean result;
                if (isCompositStrategy) {
                    //复合策略验证
                    result = teamDao.validCompositStrategyOnTeam(team, id, name);
                } else {
                    //简单策略验证
                    result = teamDao.validSimpleStrategyOnTeam(team, id, name);
                }

                //根据复合策略的类型判断
                String andStrategy="TeamAndStrategy";
                if (andStrategy.equals(strategyName)) {
                    //如果是and则一个策略不满足就返回false
                    if (!result) {
                        return false;
                    }
                } else{
                    //如果是or则一个策略满足就返回true
                    if (result) {
                        return true;
                    }
                }
            }

            //遍历完所有策略后，根据复合策略的类型判断
            String andStrategy="TeamAndStrategy";
            if (andStrategy.equals(strategyName)) {
                //如果是and且所有策略都符合返回true
                return true;

            } else{
                //如果是or且所有策略都不符合返回false
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //异常
        return null;
    }

    @Override
    public void getSimpleStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String strategyName,HashMap result) {
        try {
            //用反射得到获取特定策略的dao层方法
            String teamDaoMethodName = "get" + strategyName + "ByStrategyId";
            Method teamDaoMethod = TeamDao.class.getMethod(teamDaoMethodName, BigInteger.class);

            //得到特定策略的对象
            Object strategy = teamDaoMethod.invoke(teamDao, strategyId);
            String limitValue="MemberLimitStrategy";
            if(limitValue.equals(strategyName)){
                result.put(2,strategy);
            }
            String value="CourseMemberLimitStrategy";
            if(value.equals(strategyName)){
                if(!result.keySet().contains(1)){
                    List<CourseMemberLimitStrategy> courseMemberLimitStrategyList=new ArrayList<>();
                    courseMemberLimitStrategyList.add((CourseMemberLimitStrategy)strategy);
                    result.put(1,courseMemberLimitStrategyList);
                }
                else{
                    ((List<CourseMemberLimitStrategy>)(result.get(1))).add((CourseMemberLimitStrategy)strategy);
                }
            }
            String cousesStrategyValue="ConflictCourseStrategy";
            if(cousesStrategyValue.equals(strategyName)){
                if(!result.keySet().contains(0)){
                    List<ConflictCourseStrategy> conflictCourseStrategyList=new ArrayList<>();
                    conflictCourseStrategyList.add((ConflictCourseStrategy)strategy);
                    result.put(0,conflictCourseStrategyList);
                }
                else{
                    ((List<ConflictCourseStrategy>)(result.get(0))).add((ConflictCourseStrategy)strategy);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCompositStrategyOnTeam(BigInteger courseId,BigInteger strategyId,String strategyName,HashMap result){

        try {
            //用反射得到获取复合策略的dao层方法
            String teamDaoMethodName = "getCompositStrategyByStrategyId";
            Method teamDaoMethod = TeamDao.class.getMethod(teamDaoMethodName, BigInteger.class,String.class);

            //得到复合策略的对象
            CompositStrategy compositStrategy = (CompositStrategy)teamDaoMethod.invoke(teamDao, strategyId, strategyName);


            //得到复合策略中的策略列表
            List<StrategyPair> strategyNameAndIdList=compositStrategy.getStrategyNameAndIdList();

            //遍历每一个策略
            for (StrategyPair strategyPair : strategyNameAndIdList) {
                String name = strategyPair.getStrategyName();
                BigInteger id=strategyPair.getStrategyId();

                //判断该策略是否为复合策略
                Boolean isCompositStrategy = false;
                String andStrategyValue="TeamAndStrategy";
                String orStrategyValue="TeamOrStrategy";
                if(andStrategyValue.equals(name)||orStrategyValue.equals(name)){
                    isCompositStrategy=true;
                }

                if (isCompositStrategy) {
                    //复合策略验证
                    teamDao.getCompositStrategyOnTeam(courseId,id,name,result);
                } else {
                    //简单策略验证
                    teamDao.getSimpleStrategyOnTeam(courseId,id,name,result);
                }

                //根据复合策略的类型判断
                String teamValue="TeamAndStrategy";
                if (teamValue.equals(strategyName)) {
                    if(!result.keySet().contains(3)){
                        List<Integer> chooseList=new ArrayList<>();
                        chooseList.add(0);
                        result.put(3,chooseList);
                    }
                    else{
                        ((List<Integer>)(result.get(3))).add(0);
                    }
                }
                else{
                    if(!result.keySet().contains(3)){
                        List<Integer> chooseList=new ArrayList<>();
                        chooseList.add(1);
                        result.put(3,chooseList);
                    }
                    else{
                        ((List<Integer>)(result.get(3))).add(1);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CompositStrategy getCompositStrategyByStrategyId(BigInteger strategyId,String strategyName) throws StrategyNotFoundException {
        CompositStrategy compositStrategy=new CompositStrategy();
        String teamAndStrategyValue="TeamAndStrategy";
        String teamOrStrategyValue="TeamOrStrategy";
        if(teamAndStrategyValue.equals(strategyName)){
            compositStrategy.setStrategyNameAndIdList(teamMapper.getStrategyPairByTeamAndStrategyId(strategyId));
        }
        if(teamOrStrategyValue.equals(strategyName)){
            compositStrategy.setStrategyNameAndIdList(teamMapper.getStrategyPairByTeamOrStrategyId(strategyId));
        }
        return compositStrategy;
    }

    @Override
    public void deleteTeamStrategyListByCourseId(BigInteger courseId) throws StrategyNotFoundException {

    }

    @Override
    public void deleteCourseMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {

    }

    @Override
    public void deleteConflictCourseStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {

    }
}