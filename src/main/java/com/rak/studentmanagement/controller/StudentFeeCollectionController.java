package com.rak.studentmanagement.controller;

import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;
import com.rak.studentmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentFeeCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(StudentFeeCollectionController.class);
    private final StudentService studentService;

    public StudentFeeCollectionController(final StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/school/fee")
    public ResponseEntity<ReceiptResponse> performFeePayment(@RequestBody final PaymentRequest paymentRequest) {
        logger.info("Perform fee payment for Student ID :: [{}]", paymentRequest.getStudentDetails().getStudentId());
        return ResponseEntity.ok(studentService.performFeePayment(paymentRequest));
    }
    @GetMapping("/receipt/detail/{studentId}")
    public ResponseEntity<ReceiptResponse> getStudentReceiptDetails(@PathVariable final long studentId) {
        logger.info("Get student Receipt Detail for Student ID:: [{}]", studentId);
        return ResponseEntity.ok(studentService.getStudentReceiptDetails(studentId));
    }
}
