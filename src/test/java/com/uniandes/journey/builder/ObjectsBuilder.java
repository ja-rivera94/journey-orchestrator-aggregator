package com.uniandes.journey.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniandes.journey.client.models.OfferApiResponse;
import com.uniandes.journey.client.models.PostApiResponse;
import com.uniandes.journey.client.models.RouteApiResponse;

public class ObjectsBuilder {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String JSON_BODY_POST = "{\n" +
            "    \"createdAt\": \"2023-03-01T15:32:34.118338\",\n" +
            "    \"id\": 2.0,\n" +
            "    \"plannedEndDate\": \"2023-03-01T00:00:00\",\n" +
            "    \"plannedStartDate\": \"2023-02-27T00:00:00\",\n" +
            "    \"routeId\": 9.0,\n" +
            "    \"userId\": 1.0\n" +
            "}";

    private static final String JSON_BODY_OFFER = "{\n" +
            "        \"createdAt\": \"2023-03-01T15:38:03.626133\",\n" +
            "        \"description\": \"descripción del paquete a llevar\",\n" +
            "        \"fragile\": true,\n" +
            "        \"id\": 1.0,\n" +
            "        \"offer\": 444.0,\n" +
            "        \"postId\": 2.0,\n" +
            "        \"size\": \"LARGE\",\n" +
            "        \"userId\": 1.0\n" +
            "    }";

    private static final String JSON_BODY_ROUTE = "{\n" +
            "    \"bagCost\": 4000.0,\n" +
            "    \"createdAt\": \"2023-03-01T15:36:22.320380\",\n" +
            "    \"destinyAirportCode\": \"SXB\",\n" +
            "    \"destinyCountry\": \"medellin\",\n" +
            "    \"expireAt\": \"2023-03-31T15:36:22.320380\",\n" +
            "    \"id\": 1.0,\n" +
            "    \"sourceAirportCode\": \"SKG\",\n" +
            "    \"sourceCountry\": \"bogota\"\n" +
            "}";

    public static PostApiResponse buildPostApiResponse() throws JsonProcessingException {
        return objectMapper.readValue(JSON_BODY_POST, PostApiResponse.class);
    }

    public static OfferApiResponse buildOfferApiResponse() throws JsonProcessingException {
        return objectMapper.readValue(JSON_BODY_OFFER, OfferApiResponse.class);
    }

    public static RouteApiResponse buildRouteApiResponse() throws JsonProcessingException {
        return objectMapper.readValue(JSON_BODY_ROUTE, RouteApiResponse.class);
    }

}
