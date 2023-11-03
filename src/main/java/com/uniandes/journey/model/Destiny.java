package com.uniandes.journey.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Destiny {
    private String airportCode;
    private String country;
}
