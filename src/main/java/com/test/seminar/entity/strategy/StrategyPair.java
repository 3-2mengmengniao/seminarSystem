package com.test.seminar.entity.strategy;

import java.math.BigInteger;
/**
 * @author xmr
 * @date 2018/11/28
 */
public class StrategyPair {
    private String strategyName;
    private BigInteger strategyId;

    public String getStrategyName() { return strategyName; }

    public void setStrategyName(String strategyName) { this.strategyName = strategyName; }

    public BigInteger getStrategyId() { return strategyId; }

    public void setStrategyId(BigInteger strategyId) { this.strategyId = strategyId; }
}
