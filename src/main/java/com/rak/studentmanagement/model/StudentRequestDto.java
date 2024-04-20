package com.rak.studentmanagement.model;

public class StudentRequestDto {
    private long studentId;
    private String studentName;
    private String mobileNumber;
    private SchoolDto schoolDetail;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public SchoolDto getSchoolDetail() {
        return schoolDetail;
    }

    public void setSchoolDetail(SchoolDto schoolDetail) {
        this.schoolDetail = schoolDetail;
    }
}
