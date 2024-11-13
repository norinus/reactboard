package com.lab.reactboard.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. EntityNotFoundException 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "요청한 리소스를 찾을 수 없습니다.");
        body.put("details", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // 2. IllegalArgumentException 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "잘못된 요청 인자입니다.");
        body.put("details", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // 3. ValidationException 처리
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "유효성 검사에 실패했습니다.");
        body.put("details", ex.getConstraintViolations());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    // 4. 예기치 못한 Exception 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "예기치 못한 오류가 발생했습니다.");
        body.put("details", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
