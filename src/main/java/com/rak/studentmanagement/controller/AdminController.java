package com.rak.studentmanagement.controller;

import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.model.StudentRequestDto;
import com.rak.studentmanagement.service.StudentManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rak.studentmanagement.constant.AdminConstant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
@RestController
@RequestMapping(value = ADMIN_RESOURCE_ROOT, produces = APPLICATION_JSON_VALUE)
@Validated
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final StudentManagementService studentManagementService;

    public AdminController(final StudentManagementService studentManagementService) {
        this.studentManagementService = studentManagementService;
    }

    @Operation(summary = "Process a new student ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New student processed sucessfully")
    })
    @PostMapping(BASE_RESOURCE)
    public ResponseEntity<StudentDto> createStudent(@Validated @RequestBody final StudentRequestDto studentRequestDto) {
        logger.info("Create Student details for student ID [{}] ", studentRequestDto.getStudentName());
        return ok(studentManagementService.createStudent(studentRequestDto));
    }

    @Operation(summary = "Delete a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student Deleted Successfully")
    })
    @DeleteMapping(DELETE_STUDENT_BY_STUDENT_ID)
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable final Long studentId) {
        logger.info("Delete Student for student ID [{}] ", studentId);
        return ok(studentManagementService.deleteStudent(studentId));
    }

    @Operation(summary = "Update student details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated sucessfully")
    })

    @PutMapping(UPDATE_STUDENT_BY_STUDENT_ID)
    public ResponseEntity<StudentDto> updateStudent(@PathVariable final long studentId,
                                                    @RequestBody final StudentRequestDto studentRequestDto) {
        logger.info("Update Student for student ID [{}] ", studentId);
        return ok(studentManagementService.updateStudent(studentId, studentRequestDto));
    }

    @Operation(summary = "retrieve  all student by school name and grade ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "all student retrieved successfuly")
    })
    @GetMapping(ALL_STUDENT_BY_SCHOOLNAME_GRADE)
    public ResponseEntity<List<StudentDto>> getStudentsBySchoolAndGrade(@PathVariable final String schoolName,
                                                                        @PathVariable final String grade) {
        logger.info("Get List Of Students By School Name[{}] and Grade [{}] ", schoolName, grade);
        return ok(studentManagementService.getAllStudents(schoolName, grade));
    }

    @Operation(summary = "retrieve student by student id and school name ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "student retrieved successfuly")
    })
    @GetMapping(RETRIEVE_STUDENT_BY_STUDENTID_SCHOOLNAME)
    public ResponseEntity<StudentDto> getStudent(@PathVariable final long studentId,
                                                 @PathVariable final String schoolName) {
        logger.info("Get Student details for student ID [{}] in School name ", studentId, schoolName);
        return ok(studentManagementService.getStudentByIdAndSchool(studentId, schoolName));
    }
}
