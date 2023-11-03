package com.uniandes.journey.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Route {
    private Integer id;
    private Origin origin;
    private Destiny destiny;
    private Double bagCost;
}
