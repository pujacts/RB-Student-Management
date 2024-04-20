package com.rak.studentmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Student Dto")
public class StudentDto {
    @Schema(description = "student id")
    private long studentId;
    @Schema(description = "student name")
    private String studentName;
    @Schema(description = "mobile number" , example = "+91 9907447760")
    @Pattern(regexp = "^\\+[0-9]{2}\\s[0-9]{10}$", message = "Invalid mobile number format")
    private String mobileNumber;
    @Schema(description = "school dto")
    private SchoolDto schoolDto;
    @Schema(description = "student grade")
    private String grade;
    @Schema(description = "schoolname")
    private String schoolName;

    @Schema(description = "payment transaction date and time")
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

    public SchoolDto getSchoolDto() {
        return schoolDto;
    }

    public void setSchoolDetail(SchoolDto schoolDto) {
        this.schoolDto = schoolDto;
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
