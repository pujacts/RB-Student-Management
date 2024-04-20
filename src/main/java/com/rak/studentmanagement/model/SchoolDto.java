package com.rak.studentmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class SchoolDto {

    @Schema(description = "student grade")
    private String grade;
    @Schema(description = "schoolname")
    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
