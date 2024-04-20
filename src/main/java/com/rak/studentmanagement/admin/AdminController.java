package com.rak.studentmanagement.admin;

import com.rak.studentmanagement.model.StudentDetailRequest;
import com.rak.studentmanagement.model.StudentResponse;
import com.rak.studentmanagement.service.StudentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/student")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final StudentManagementService studentManagementService;

    public AdminController(final StudentManagementService studentManagementService) {
        this.studentManagementService = studentManagementService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody final StudentDetailRequest studentDetailRequest) {
        logger.info("Create Student details for student ID [{}] ", studentDetailRequest.getStudentId());
        return ResponseEntity.ok(studentManagementService.createStudent(studentDetailRequest));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable final Long studentId) {
        logger.info("Delete Student for student ID [{}] ", studentId);
        return ResponseEntity.ok(studentManagementService.deleteStudent(studentId));
    }

    @PutMapping("/update")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody final StudentDetailRequest studentDetailRequest) {
        logger.info("Update Student for student ID [{}] ", studentDetailRequest.getStudentId());
        return ResponseEntity.ok(studentManagementService.updateStudent(studentDetailRequest));
    }
    @GetMapping("/all/{school}/{grade}")
    public ResponseEntity<StudentResponse> getStudentsBySchoolAndGrade(@PathVariable final String school, @PathVariable final String grade) {
        logger.info("Get List Of Students By School [{}] and Grade [{}] ", school, grade);
        return ResponseEntity.ok(studentManagementService.getAllStudents(school, grade));
    }

    @GetMapping("/{studentId}/{school}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable final long studentId, @PathVariable final String school) {
        logger.info("Get Student details for student ID [{}] in School ", studentId, school);
        return ResponseEntity.ok(studentManagementService.getStudentByIdAndSchool(studentId, school));
    }
}
