package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.PaymentRequestDto;
import com.rak.studentmanagement.model.ReceiptResponseDto;


public interface StudentService {
    ReceiptResponseDto processFee(final PaymentRequestDto paymentRequest);
    ReceiptResponseDto getStudentReceiptDetails(final Long studentId);
}
