package com.uniandes.journey.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Origin {
    private String airportCode;
    private String country;
}
