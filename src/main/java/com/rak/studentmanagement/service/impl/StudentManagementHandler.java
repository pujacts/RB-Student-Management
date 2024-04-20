package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.entity.Student;
import com.rak.studentmanagement.exception.BusinessException;
import com.rak.studentmanagement.model.StudentDetail;
import com.rak.studentmanagement.model.StudentDetailRequest;
import com.rak.studentmanagement.model.StudentResponse;
import com.rak.studentmanagement.repository.StudentRepository;
import com.rak.studentmanagement.service.StudentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.rak.studentmanagement.constant.StudentManagementConstants.*;
import static com.rak.studentmanagement.util.StudentUtility.mapStudentToStudentResponse;

@Service
public class StudentManagementHandler implements StudentManagementService {
    private static final Logger logger = LoggerFactory.getLogger(StudentManagementHandler.class);
    private final StudentRepository studentRepository;

    public StudentManagementHandler(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse createStudent(final StudentDetailRequest studentDetailRequest) {
        logger.info("Create Student of Student ID :: [{}] ", studentDetailRequest.getStudentId());
        StudentResponse studentResponse = new StudentResponse();
        try {
            Student student = new Student();
            student.setGrade(studentDetailRequest.getSchoolDetail().getGrade());
            student.setName(studentDetailRequest.getStudentName());
            student.setMobileNumber(studentDetailRequest.getMobileNumber());
            student.setSchoolName(studentDetailRequest.getSchoolDetail().getSchoolName());
            student = studentRepository.save(student);
            StudentDetail studentDetail = mapStudentToStudentResponse(student);
            studentResponse.setStudentDetails(List.of(studentDetail));
            studentResponse.setStatusMessage(SUCCESS);
            studentResponse.setStatusCode(SUCCESS_CREATED_CODE);
        } catch (Exception ex) {
            String errMsg = ex.getLocalizedMessage();
            logger.error(errMsg);
            studentResponse.setStatusCode(SERVER_ERROR);
            studentResponse.setStatusMessage(errMsg);
        }
        return studentResponse;
    }

    @Override
    public StudentResponse deleteStudent(final Long studentId) {
        logger.info("Delete Student of Student ID :: [{}] ", studentId);
        StudentResponse studentResponse = new StudentResponse();
        try {
            Optional<Student> student = studentRepository.findByStudentId(studentId);
            if (student.isPresent()) {
                studentRepository.delete(student.get());
                studentResponse.setStatusMessage(SUCCESS);
                studentResponse.setStatusCode(NO_CONTENT);
            } else {
                studentResponse.setStatusMessage(STUDENT_NOT_FOUND);
                studentResponse.setStatusCode(NOT_FOUND);
            }
        } catch (Exception ex) {
            String errMsg = String.format("Failed to remove student detail :: [{}]", studentId);
            logger.error(errMsg);
            throw new BusinessException(errMsg);
        }
        return studentResponse;
    }

    @Override
    public StudentResponse updateStudent(final StudentDetailRequest studentDetailRequest) {
        logger.info("Update Student of Student ID :: [{}] ", studentDetailRequest.getStudentId());
        Optional<Student> studentOptional = studentRepository.findByStudentId(studentDetailRequest.getStudentId());
        StudentResponse studentResponse = new StudentResponse();
        try {
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                student.setGrade(studentDetailRequest.getSchoolDetail().getGrade());
                student.setName(studentDetailRequest.getStudentName());
                student.setMobileNumber(studentDetailRequest.getMobileNumber());
                student.setSchoolName(studentDetailRequest.getSchoolDetail().getSchoolName());
                student = studentRepository.save(student);
                StudentDetail studentDetail = mapStudentToStudentResponse(student);
                studentResponse.setStudentDetails(List.of(studentDetail));
                studentResponse.setStatusMessage(SUCCESS);
                studentResponse.setStatusCode(SUCCESS_CODE);
            } else {
                studentResponse.setStatusMessage(STUDENT_NOT_FOUND);
                studentResponse.setStatusCode(NOT_FOUND);
            }
            return studentResponse;
        } catch (Exception ex) {
            String errMsg = ex.getLocalizedMessage();
            logger.error(errMsg);
            studentResponse.setStatusCode(SERVER_ERROR);
            studentResponse.setStatusMessage(errMsg);
            throw new IllegalStateException("Student Not Found");
        }
    }

    @Override
    public StudentResponse getAllStudents(final String school, final String grade) {
        logger.info("Get All Student of School :: [{}] and Grade :: [{}] ", school, grade);
        StudentResponse studentResponse = new StudentResponse();
        try {
            List<Student> studentList = studentRepository.findBySchoolNameAndGrade(school, grade);
            List<StudentDetail> studentDetailList = mapStudentToStudentResponse(studentList);
            studentResponse.setStudentDetails(studentDetailList);
            studentResponse.setStatusMessage(SUCCESS);
            studentResponse.setStatusCode(SUCCESS_CODE);
        } catch (Exception ex) {
            String errMsg = ex.getLocalizedMessage();
            logger.error(errMsg);
            studentResponse.setStatusCode(SERVER_ERROR);
            studentResponse.setStatusMessage(errMsg);
        }
        return studentResponse;
    }

    @Override
    public StudentResponse getStudentByIdAndSchool(final long studentId, final String school) {
        logger.info("Get Student of Student ID :: [{}] and School :: [{}] ", studentId, school);
        StudentResponse studentResponse = new StudentResponse();
        try {
            Optional<Student> student = studentRepository.findByStudentIdAndSchoolName(studentId, school);
            if (student.isPresent()) {
                StudentDetail studentDetail = mapStudentToStudentResponse(student.get());
                studentResponse.setStudentDetails(List.of(studentDetail));
                studentResponse.setStatusMessage(SUCCESS);
                studentResponse.setStatusCode(SUCCESS_CODE);
            } else {
                studentResponse.setStatusMessage(STUDENT_NOT_FOUND);
                studentResponse.setStatusCode(NOT_FOUND);
            }
        } catch (Exception ex) {
            String errMsg = ex.getLocalizedMessage();
            logger.error(errMsg);
            studentResponse.setStatusCode(SERVER_ERROR);
            studentResponse.setStatusMessage(errMsg);
        }
        return studentResponse;
    }
}
