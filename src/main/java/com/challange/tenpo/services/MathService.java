package com.challange.tenpo.services;

import com.challange.tenpo.dtos.ResultResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MathService {

    public ResultResponseDTO sum(double num1, double num2) {
        log.info("[Log] Processing Math Sum: {} + {}", num1, num2);
        return new ResultResponseDTO(num1 + num2);
    }

}
