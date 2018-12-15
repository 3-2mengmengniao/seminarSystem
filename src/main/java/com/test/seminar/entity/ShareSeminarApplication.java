package com.test.seminar.entity;

import java.math.BigInteger;

public class ShareSeminarApplication {
    private BigInteger id;
    private BigInteger mainCourseId;
    private BigInteger subCourseId;
    private BigInteger subCourseTeacherId;
    private int status;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getMainCourseId() {
        return mainCourseId;
    }

    public void setMainCourseId(BigInteger mainCourseId) {
        this.mainCourseId = mainCourseId;
    }

    public BigInteger getSubCourseId() {
        return subCourseId;
    }

    public void setSubCourseId(BigInteger subCourseId) {
        this.subCourseId = subCourseId;
    }

    public BigInteger getSubCourseTeacherId() {
        return subCourseTeacherId;
    }

    public void setSubCourseTeacherId(BigInteger subCourseTeacherId) {
        this.subCourseTeacherId = subCourseTeacherId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
