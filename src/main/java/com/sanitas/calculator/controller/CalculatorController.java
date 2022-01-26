package com.sanitas.calculator.controller;

import com.sanitas.calculator.domain.Request;
import com.sanitas.calculator.domain.Response;
import com.sanitas.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/calc", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping(path = "sum")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> sum(@RequestBody @Valid Request request){
        return new ResponseEntity<>(new Response(calculatorService.sum(request)), HttpStatus.OK);
    }

    @PostMapping(path = "subtraction")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> subtraction(@RequestBody @Valid Request request){
        return new ResponseEntity<>(new Response(calculatorService.subtraction(request)), HttpStatus.OK);
    }

    @PostMapping(path = "sum2")
    public ResponseEntity<Response> sum2(@RequestBody @Valid Request request){
        return new ResponseEntity<>(calculatorService.sum2(request), HttpStatus.OK);
    }

    @PostMapping(path = "subtraction2")
    public ResponseEntity<Response> subtraction2(@RequestBody @Valid Request request){
        return new ResponseEntity<>(calculatorService.subtraction2(request), HttpStatus.OK);
    }
}