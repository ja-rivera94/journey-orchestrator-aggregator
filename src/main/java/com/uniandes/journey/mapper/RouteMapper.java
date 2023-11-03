package com.uniandes.journey.mapper;

import com.uniandes.journey.client.models.RouteApiResponse;
import com.uniandes.journey.model.Destiny;
import com.uniandes.journey.model.Origin;
import com.uniandes.journey.model.Route;
import jakarta.inject.Singleton;

@Singleton
public class RouteMapper implements Mapper<RouteApiResponse, Route> {

    @Override
    public Route map(RouteApiResponse input) {
        return Route.builder()
                .id(input.getId().intValue())
                .origin(Origin.builder()
                        .airportCode(input.getSourceAirportCode())
                        .country(input.getSourceCountry())
                        .build())
                .destiny(Destiny.builder()
                        .airportCode(input.getDestinyAirportCode())
                        .country(input.getDestinyCountry())
                        .build())
                .bagCost(input.getBagCost())
                .build();
    }
}
