package com.test.seminar.exception;

/**
 * @author cxh
 * date 2018/11/30
 */
public class CourseClassNotFoundException extends RuntimeException{

    public CourseClassNotFoundException(String message) {
        super(message);
    }

    public CourseClassNotFoundException() {
    }
}
