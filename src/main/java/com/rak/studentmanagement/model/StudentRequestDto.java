package com.rak.studentmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Student Request Dto")
public class StudentRequestDto {

    @Schema(description = "Student Name")
    private String studentName;
    @Schema(description = "Student Mobile Number")
    @Pattern(regexp = "^\\+[0-9]{2}\\s[0-9]{10}$", message = "Invalid mobile number format")
    private String mobileNumber;

    @Schema(description = "School Dto")
    private SchoolDto schoolDetail;

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
