package com.rak.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.OffsetDateTime;

@JsonRootName("receiptData")
@Schema(description = "Fee Receipt")
public class FeeReceiptDto implements Serializable {

    @JsonProperty("Date & Time")
    @Schema(description = "payment transaction date and time")
    private OffsetDateTime transactionDateAndTime;

    @JsonProperty("Student Name")
    @Schema(description = "student name")
    private String studentName;

    @JsonProperty("Student Id")
    @Schema(description = "student id")
    private Long studentId;

    @JsonProperty("Reference #")
    @Schema(description = "fee receipt reference id")
    private Long referenceId;

    @JsonProperty("Card #")
    @Schema(description = "card number")
    private String cardNumber;

    @JsonProperty("Card Type")
    @Schema(description = "card type")
    private String cardType;

    @Schema(description = "tansaction amount")
    private double transactionAmount;

    public OffsetDateTime getTransactionDateAndTime() {
        return transactionDateAndTime;
    }

    public void setTransactionDateAndTime(OffsetDateTime transactionDateAndTime) {
        this.transactionDateAndTime = transactionDateAndTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
