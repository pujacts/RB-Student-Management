package com.rak.studentmanagement.util;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.model.StudentDetail;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentUtility {
    public static StudentDetail mapStudentToStudentResponse(Student student) {
        Assert.notNull(student, "Student is null");
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentId(student.getStudentId());
        studentDetail.setStudentName(student.getName());
        studentDetail.setGrade(student.getGrade());
        studentDetail.setMobileNumber(student.getMobileNumber());
        studentDetail.setSchoolName(student.getSchoolName());
        return studentDetail;
    }

    public static List<StudentDetail> mapStudentToStudentResponse(List<Student> students) {
        return Optional.ofNullable(students)
                .orElse(Collections.emptyList())
                .stream()
                .map(student -> {
                    StudentDetail studentDetail = new StudentDetail();
                    studentDetail.setStudentId(student.getStudentId());
                    studentDetail.setStudentName(student.getName());
                    studentDetail.setGrade(student.getGrade());
                    studentDetail.setMobileNumber(student.getMobileNumber());
                    studentDetail.setSchoolName(student.getSchoolName());
                    return studentDetail;
                })
                .collect(Collectors.toList());
    }
}
