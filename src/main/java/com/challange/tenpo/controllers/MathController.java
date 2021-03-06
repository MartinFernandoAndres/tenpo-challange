package com.challange.tenpo.controllers;

import com.challange.tenpo.dtos.ResultMathDTO;
import com.challange.tenpo.services.MathService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Api(tags = "Math")
@RestController
@RequestMapping("/api/math")
public class MathController {

    private final MathService mathService;

    @GetMapping("/sum")
    @ApiOperation(value = "Suma")
    public ResponseEntity<ResultMathDTO> sum(
            @RequestHeader(required = true, value = "Authorization") String headerAuth,
            @RequestParam(required = true) @NotEmpty double num1,
            @RequestParam(required = true) @NotEmpty double num2) {
        return ResponseEntity.ok(mathService.sum(num1, num2));
    }
}