package com.challange.tenpo.services;

import com.challange.tenpo.dtos.ResultMathDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathServiceTest {

    private final MathService math = new MathService();

    @Test
    public void GivenSum_WhenAAndB_ShouldReturnResult() {
        // Arrange
        double a = 1.0;
        double b = 2.0;
        ResultMathDTO expectedResult = new ResultMathDTO(3.0);

        // Act
        ResultMathDTO result = math.sum(a, b);

        // Assert
        assertEquals(result, expectedResult);
    }

}
