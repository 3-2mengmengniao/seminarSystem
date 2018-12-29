package com.test.seminar.entity.strategy.impl;


import com.test.seminar.entity.strategy.StrategyPair;
import com.test.seminar.entity.strategy.AbstractStrategy;

import java.math.BigInteger;
import java.util.List;

/**
 * 复合策略
 * @author wzw
 * date 2018/12/25
 */
public class CompositStrategy extends AbstractStrategy{
    private BigInteger id;
    private List<StrategyPair> strategyNameAndIdList;

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
}
