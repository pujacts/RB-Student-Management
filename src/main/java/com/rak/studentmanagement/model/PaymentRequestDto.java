package com.rak.studentmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Payment RequestDto")
public class PaymentRequestDto {
    @Schema(description = "student data")
    private StudentDto studentDto;
    @Schema(description = "card data")
    private CardDto cardDto;

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }
}
