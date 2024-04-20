package com.rak.studentmanagement.controller;

import com.rak.studentmanagement.model.PaymentRequestDto;
import com.rak.studentmanagement.model.ReceiptResponseDto;
import com.rak.studentmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.rak.studentmanagement.constant.StudentManagementConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
@RestController
@Validated
@RequestMapping(value = STUDENT_FEE_COLLECTION_RESOURCE_ROOT, produces = APPLICATION_JSON_VALUE)
public class StudentFeeCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(StudentFeeCollectionController.class);

    private final StudentService studentService;

    public StudentFeeCollectionController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Make fee payment for student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully processed payment")
    })
    @PostMapping(STUDENT_SCHOOL_FEE)
    public ResponseEntity<ReceiptResponseDto> processFee(@Validated @RequestBody final PaymentRequestDto paymentRequest) {
        logger.info("Perform fee payment for Student ID :: [{}]", paymentRequest.getStudentDto().getStudentId());
        return ResponseEntity.ok(studentService.processFee(paymentRequest));
    }

    @Operation(summary = "Get receipt of student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved payment detail")
    })
    @GetMapping(STUDENT_FEES_RECEIPT)
    public ResponseEntity<ReceiptResponseDto> getStudentReceiptDetails(@PathVariable final long studentId) {
        logger.info("Get student Receipt Detail for Student ID:: [{}]", studentId);
        return ResponseEntity.ok(studentService.getStudentReceiptDetails(studentId));
    }
}
