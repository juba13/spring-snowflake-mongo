/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba.springtest.setup;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<HashMap<String,Object>> handleAllExceptions(Exception ex, ServletWebRequest request ) {
        
         Map errorMessage = new HashMap<String,Object>();
         errorMessage.put("timestamp",  Calendar.getInstance().getTime().toString());
         errorMessage.put("error",  "Internal Server Error");
         errorMessage.put("message", ex.getMessage());
         errorMessage.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
         return new ResponseEntity( errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
}
