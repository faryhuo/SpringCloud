package com.springcloud.service.catalog.config;

import com.springcloud.service.catalog.entities.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandle{

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception e){
      log.error(e.getMessage(),e);
      return ResponseEntity.error(e.getMessage());
    }
}
