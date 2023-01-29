package com.metrix.webportal.validation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@Controller
//1. Annotation to indicate this class is controller advise to handle custom exception
public class ControllerAdvise {
@ExceptionHandler   
        //2. Annotation to indicate this method will handle exception with type MetrixException.class
    public ModelAndView handleMetrixException(MetrixException e){
        return new ModelAndView("error", "ErrObject", e);
    }
}