package com.challange.tenpo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Double.compare;

@Data
@AllArgsConstructor
public class ResultMathDTO {

    private Double result;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultMathDTO other = (ResultMathDTO) obj;
        return (compare(other.result, this.result) == 0);
    }
}
