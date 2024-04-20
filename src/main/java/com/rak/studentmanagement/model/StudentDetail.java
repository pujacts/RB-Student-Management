package com.rak.studentmanagement.model;

public class StudentDetail {
    private long studentId;
    private String studentName;
    private String mobileNumber;
    private SchoolDetail schoolDetail;
    private String grade;
    private String schoolName;
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

    public SchoolDetail getSchoolDetail() {
        return schoolDetail;
    }

    public void setSchoolDetail(SchoolDetail schoolDetail) {
        this.schoolDetail = schoolDetail;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
