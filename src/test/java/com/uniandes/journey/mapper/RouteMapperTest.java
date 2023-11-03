package com.uniandes.journey.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniandes.journey.client.models.RouteApiResponse;
import com.uniandes.journey.model.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.uniandes.journey.builder.ObjectsBuilder.buildRouteApiResponse;


@ExtendWith(MockitoExtension.class)
class RouteMapperTest {
    private RouteMapper routeMapper;

    @Test
    void shouldMapRouteApiResponse() throws JsonProcessingException {
        routeMapper = new RouteMapper();
        RouteApiResponse routeApiResponse =  buildRouteApiResponse();
        Route result = routeMapper.map(routeApiResponse);

        Assertions.assertEquals(result.getBagCost(), routeApiResponse.getBagCost());
        Assertions.assertEquals(result.getId(), routeApiResponse.getId().intValue());
        Assertions.assertEquals(result.getDestiny().getAirportCode(), routeApiResponse.getDestinyAirportCode());
        Assertions.assertEquals(result.getDestiny().getCountry(), routeApiResponse.getDestinyCountry());
        Assertions.assertEquals(result.getOrigin().getAirportCode(), routeApiResponse.getSourceAirportCode());
        Assertions.assertEquals(result.getOrigin().getCountry(), routeApiResponse.getSourceCountry());
    }
}