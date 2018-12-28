package com.test.seminar.entity.strategy.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.Strategy;
import com.test.seminar.entity.strategy.StrategyPair;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;

/**
 * @author wzw
 * date 2018/12/25
 */
public class TeamOrStrategy extends Strategy {
    private BigInteger id;
    List<StrategyPair> strategyNameAndIdList;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public List<StrategyPair> getStrategyNameAndIdList() {
        return strategyNameAndIdList;
    }

    public void setStrategyNameAndIdList(List<StrategyPair> strategyNameAndIdList) {
        this.strategyNameAndIdList = strategyNameAndIdList;
    }

//    @Autowired
//    CourseDao courseDao;
//
//    @Override
//    public Boolean isValid(Team team) {
//        //遍历每一个策略
//        for (StrategyPair strategyNameAndId : strategyNameAndIdList) {
//            //获得策略类名和Id
//            String strategyName = strategyNameAndId.getStrategyName();
//            BigInteger strategyId = strategyNameAndId.getStrategyId();
//            try {
//                //用反射得到获取特定策略的dao层方法
//                String courseDaoMethodName = "get" + strategyName + "ByStrategyId";
//                Method courseDaoMethod = CourseDao.class.getMethod(courseDaoMethodName, BigInteger.class);
//                //得到特定策略的对象
//                Object strategy = courseDaoMethod.invoke(courseDao, strategyId);
//                //得到特定策略类的isValid方法
//                Class strategyClass = Class.forName(strategyName);
//                Method isValid = strategyClass.getMethod("isValid", Team.class);
//                //调用特定策略类的isValid方法
//                Object result = isValid.invoke(strategy, team);
//                //只要有一个策略满足，就返回true
//                if ((Boolean) result) {
//                    return true;
//                }
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//
//    }
}
