package com.belong.telecom.web.controller.rest;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    @Hidden
    public String getErrorPath() {
        return "<center><h1>Something went wrong</h1></center>";
    }
}
