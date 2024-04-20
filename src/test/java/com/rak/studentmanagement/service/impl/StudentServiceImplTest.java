package com.rak.studentmanagement.service.impl;

import com.rak.studentmanagement.model.StudentDto;
import com.rak.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import com.rak.studentmanagement.model.PaymentRequestDto;
import com.rak.studentmanagement.model.ReceiptResponseDto;

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
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();

        StudentDto studentDetails = new StudentDto();
        studentDetails.setStudentId(1l);

        paymentRequestDto.setStudentDetails(studentDetails);

        ReceiptResponseDto receiptResponse = new ReceiptResponseDto();
        receiptResponse.setStatusMessage("SUCCESS");

        given(feeServiceClient.performFeePayment(paymentRequestDto)).willReturn(receiptResponse);

        ReceiptResponseDto response = studentService.processFee(paymentRequestDto);

        assertEquals("SUCCESS", response.getStatusMessage());
    }

    @Test
    void testGetStudentReceiptDetails() {
        ReceiptResponseDto receiptResponseDto = new ReceiptResponseDto();
        receiptResponseDto.setStatusMessage("SUCCESS");

        given(feeServiceClient.fetchReceiptDetails(anyLong())).willReturn(receiptResponseDto);

        ReceiptResponseDto response = studentService.getStudentReceiptDetails(1L);

        assertEquals("SUCCESS", response.getStatusMessage());
    }
}
