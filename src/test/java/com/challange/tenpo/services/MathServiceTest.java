package com.challange.tenpo.services;

import com.challange.tenpo.dtos.ResultResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathServiceTest {

    private final MathService math = new MathService();

    @Test
    public void GivenSum_WhenAAndB_ShouldReturnResult() {
        // Arrange
        double a = 1.0;
        double b = 2.0;
        ResultResponseDTO expectedResult = new ResultResponseDTO(3.0);

        // Act
        ResultResponseDTO result = math.sum(a, b);

        // Assert
        assertEquals(result, expectedResult);
    }

}
