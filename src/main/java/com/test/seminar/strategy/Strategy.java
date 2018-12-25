package com.test.seminar.strategy;

import com.test.seminar.entity.Team;

/**
 * @author wzw
 * date 2018/12/25
 */
public interface Strategy {
    Boolean isValid(Team team);
}
