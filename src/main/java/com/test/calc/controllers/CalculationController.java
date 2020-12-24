/*
 * Copyright (c) 2019.7.15
 * Developed by Ivan Mareev
 */

package com.test.calc.controllers;


import com.test.calc.services.CalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/rest")

@Api(value = "calculation service")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationController.class);

    @ApiOperation(value = "Sum", response = Integer.class)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@ApiParam("first number") Integer a, @ApiParam("second number") Integer b) {
        LOGGER.debug("Starting the addition");
        return calculationService.add(a, b);
    }

    @ApiOperation(value = "subtract", response = Integer.class)
    @GetMapping(value = "/subtract")
    public Integer subtract(@ApiParam("first number") Integer a, @ApiParam("second number") Integer b) {
        LOGGER.debug("Starting the subtraction");
        return calculationService.subtract(a, b);
    }

    @ApiOperation(value = "multiply", response = Integer.class)
    @GetMapping(value = "/multiply")
    public Integer multiply(@ApiParam("first number") Integer a, @ApiParam("second number") Integer b) {
        LOGGER.debug("Starting the multiplication");
        return calculationService.multiply(a, b);
    }

    @ApiOperation(value = "divide", response = Integer.class)
    @GetMapping(value = "/divide")
    public Integer divide(@ApiParam("first number") Integer a, @ApiParam("second number") Integer b) {
        LOGGER.debug("Starting the division");
        return calculationService.divide(a, b);
    }


}
