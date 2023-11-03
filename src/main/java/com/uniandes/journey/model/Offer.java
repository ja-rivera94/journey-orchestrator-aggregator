package com.uniandes.journey.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Offer {

    private Integer id;
    private Integer userId;
    private String description;
    private String size;
    private Boolean fragile;
    private Double offer;
    private Double score;
    private String createdAt;
}
