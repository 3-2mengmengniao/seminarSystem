package com.test.seminar.entity;

import java.math.BigInteger;

public class Teacher extends User{
    private BigInteger id;
    private String account;
    private String password;
    private int active;
    private String name;
    private String email;
    private int emailReceiveInterval;
}
