package com.test.seminar.service;

import com.test.seminar.entity.SeminarControl;

public interface RundSeminarService {

    void beginSeminar(SeminarControl seminarControl);

    void endSeminar(SeminarControl seminarControl);


}
