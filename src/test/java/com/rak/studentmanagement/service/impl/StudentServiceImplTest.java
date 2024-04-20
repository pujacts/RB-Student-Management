package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.model.StudentDetail;
import com.rak.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;

import com.rak.studentmanagement.service.FeeServiceClient;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTests {

    @Mock
    StudentRepository studentRepository;

    @Mock
    FeeServiceClient feeServiceClient;

    @InjectMocks
    StudentServiceImpl studentService;

    @Test
    void testPerformFeePayment() {
        PaymentRequest paymentRequest = new PaymentRequest();

        StudentDetail studentDetails = new StudentDetail();
        studentDetails.setStudentId(1l);

        paymentRequest.setStudentDetails(studentDetails);

        ReceiptResponse receiptResponse = new ReceiptResponse();
        receiptResponse.setStatusMessage("SUCCESS");

        given(feeServiceClient.performFeePayment(paymentRequest)).willReturn(receiptResponse);

        ReceiptResponse response = studentService.performFeePayment(paymentRequest);

        assertEquals("SUCCESS", response.getStatusMessage());
    }

    @Test
    void testGetStudentReceiptDetails() {
        ReceiptResponse receiptResponse = new ReceiptResponse();
        receiptResponse.setStatusMessage("SUCCESS");

        given(feeServiceClient.fetchReceiptDetails(anyLong())).willReturn(receiptResponse);

        ReceiptResponse response = studentService.getStudentReceiptDetails(1L);

        assertEquals("SUCCESS", response.getStatusMessage());
    }
}
