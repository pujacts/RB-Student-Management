package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.PaymentRequest;
import com.rak.studentmanagement.model.ReceiptResponse;


public interface StudentService {
    ReceiptResponse performFeePayment(final PaymentRequest paymentRequest);
    ReceiptResponse getStudentReceiptDetails(final Long studentId);
}
