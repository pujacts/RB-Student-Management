package com.rak.studentmanagement.constant;

public interface StudentManagementConstants {
    int SERVER_ERROR = 500;
    int SUCCESS_CODE = 200;
    int SUCCESS_CREATED_CODE = 201;
    int NO_CONTENT = 204;
    int BAD_REQUEST = 400;
    int NOT_FOUND = 404;
    String SUCCESS = "SUCCESS";
    String STUDENT_NOT_FOUND = "Student Not Found";
    String STUDENT_FEE_COLLECTION_RESOURCE_ROOT = "/api/school";
    String STUDENT_SCHOOL_FEE = "/student/fee";
    String STUDENT_FEES_RECEIPT = "/{studentId}/receipt";
}
