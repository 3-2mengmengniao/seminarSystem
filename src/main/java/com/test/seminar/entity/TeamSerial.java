package com.test.seminar.entity;

public class TeamSerial {
    private Integer klassSerial;
    private Integer teamSerial;

    public Integer getKlassSerial() {
        return klassSerial;
    }

    public void setKlassSerial(Integer klassSerial) {
        this.klassSerial = klassSerial;
    }

    public Integer getTeamSerial() {
        return teamSerial;
    }

    public void setTeamSerial(Integer teamSerial) {
        this.teamSerial = teamSerial;
    }

    public String getSerial(){
        return klassSerial.toString()+"-"+teamSerial.toString();
    }
}
