package com.uniandes.journey.client.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteApiResponse {
    private Double bagCost;
    private String createdAt;
    private String destinyAirportCode;
    private String destinyCountry;
    private String expireAt;
    private Double id;
    private String sourceAirportCode;
    private String sourceCountry;
}
