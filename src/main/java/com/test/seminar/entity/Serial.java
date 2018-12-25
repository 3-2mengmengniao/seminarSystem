package com.test.seminar.entity;

public class Serial {
    private Integer courseClassSerial;
    private Integer teamSerial;

    public Integer getCourseClassSerial() {
        return courseClassSerial;
    }

    public void setCourseClassSerial(Integer courseClassSerial) {
        this.courseClassSerial = courseClassSerial;
    }

    public Integer getTeamSerial() {
        return teamSerial;
    }

    public void setTeamSerial(Integer teamSerial) {
        this.teamSerial = teamSerial;
    }

    public String getSerial(){
        return courseClassSerial.toString()+"-"+teamSerial.toString();
    }
}
