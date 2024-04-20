package com.rak.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonRootName("StudentResponse")
public class StudentResponse {
    @JsonProperty("studentDetails")
    private List<StudentDetail> studentDetails;
    @JsonProperty("statusCode")
    private int statusCode;
    @JsonProperty("statusMessage")
    private String statusMessage;

    public List<StudentDetail> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<StudentDetail> studentDetails) {
        this.studentDetails = studentDetails;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
