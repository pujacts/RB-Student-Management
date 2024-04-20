package com.rak.studentmanagement.service;

import com.rak.studentmanagement.model.PaymentRequestDto;
import com.rak.studentmanagement.model.ReceiptResponseDto;


public interface FeeServiceClient {
    ReceiptResponseDto performFeePayment(final PaymentRequestDto paymentRequest);

    ReceiptResponseDto fetchReceiptDetails(final Long studentId);
}
