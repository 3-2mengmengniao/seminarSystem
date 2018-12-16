package com.test.seminar.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.seminar.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionControll {

    private static final Logger logger = LogManager.getLogger(ExceptionControll.class);

    @ResponseBody
    @ExceptionHandler(CourseClassNotFoundException.class)
    public String courseClassNotFound(Exception exception) {
//        logger.info("Not found course class", exception);
        String status="404";
        return status;
    }

    @ResponseBody
    @ExceptionHandler(CourseNotFoundException.class)
    public String courseNotFound(Exception exception) {
//        logger.info("Not found course", exception);
        String status="404";
        return status;
    }

    @ResponseBody
    @ExceptionHandler(RepetitiveRecordException.class)
    public String repetitiveRecord(Exception exception) {
//        logger.info("Record has existed", exception);
        String status="405";
        return status;
    }

    @ResponseBody
    @ExceptionHandler(RoundNotFoundException.class)
    public String roundNotFound(Exception exception) {
//        logger.info("Not found round", exception);
        String status="404";
        return status;
    }

    @ResponseBody
    @ExceptionHandler(SeminarInfoNotFoundException.class)
    public String seminarInfoNotFound(Exception exception) {
//        logger.info("Not found seminar info", exception);
        String status="404";
        return status;
    }

    @ResponseBody
    @ExceptionHandler(SeminarControlNotFoundException.class)
    public String seminarControlNotFound(Exception exception) {
//        logger.info("Not found seminar control", exception);
        String status="404";
        return status;
    }


//    @ExceptionHandler(UserNotFoundException.class)
//    @ResponseBody
//    public String userNotFound(Exception exception) {
////        logger.info("Not found seminar", exception);
//        String status="404";
//        return status;
//    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public String noMapping(Exception exception) {
//        logger.info("Not found seminar", exception);
        String status="404";
        return status;
    }



}
