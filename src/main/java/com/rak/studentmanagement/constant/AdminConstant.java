package com.rak.studentmanagement.constant;

public interface AdminConstant {

    String ADMIN_RESOURCE_ROOT = "api/admin";
    String RETRIEVE_STUDENT_BY_STUDENTID_STUDENTNAME = "/{studentId}/{school}";
    String ALL_STUDENT_BY_STUDENTNAME_GRADE = "/students/{school}/{grade}";
    String BASE_RESOURCE = "student";
    String DELETE_STUDENT_BY_STUDENT_ID = BASE_RESOURCE + "/{studentId}";

}
