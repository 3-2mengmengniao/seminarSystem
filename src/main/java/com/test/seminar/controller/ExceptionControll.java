package com.test.seminar.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.seminar.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionControll {

    private static final Logger logger = LogManager.getLogger(ExceptionControll.class);

    @ResponseBody
    @ExceptionHandler(CourseClassNotFoundException.class)
    public ResponseEntity<String> courseClassNotFound(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> courseNotFound(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(RepetitiveRecordException.class)
    public ResponseEntity<String> repetitiveRecord(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(RoundNotFoundException.class)
    public ResponseEntity<String> roundNotFound(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(SeminarInfoNotFoundException.class)
    public ResponseEntity<String> seminarInfoNotFound(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(SeminarControlNotFoundException.class)
    public ResponseEntity<String> seminarControlNotFound(Exception exception) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public String noMapping(Exception exception) {
        return "error";
    }



}
