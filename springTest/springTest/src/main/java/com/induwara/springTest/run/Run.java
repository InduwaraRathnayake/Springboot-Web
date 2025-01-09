package com.induwara.springTest.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,

    @NotEmpty // this is a validation annotation by jakarta validation
    String title,

    LocalDateTime startedOn,
    LocalDateTime completedOn,

    @Positive // this is a validation annotation by jakarta validation
    Integer miles,
    
    Location location
) {
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed date must be after started date");
        }
    }
}
