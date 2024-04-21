package com.rak.studentmanagement.global.exception;

import com.rak.studentmanagement.exception.BusinessException;

import java.util.function.Predicate;

public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return !(throwable instanceof BusinessException);
    }
}