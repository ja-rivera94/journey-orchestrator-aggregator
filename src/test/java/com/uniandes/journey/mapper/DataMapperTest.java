package com.uniandes.journey.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uniandes.journey.client.models.PostApiResponse;
import com.uniandes.journey.model.Data;
import com.uniandes.journey.model.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.uniandes.journey.builder.ObjectsBuilder.buildPostApiResponse;

class DataMapperTest {
    private DataMapper dataMapper;
    @Test
    void shouldMapDataResponse() throws JsonProcessingException {

        dataMapper = new DataMapper();

        PostApiResponse postApiResponse = buildPostApiResponse();
        Data result = dataMapper.map(postApiResponse, Route.builder().build(), new ArrayList<>());

        Assertions.assertEquals(postApiResponse.getId().intValue(), result.getId());
        Assertions.assertEquals(postApiResponse.getPlannedEndDate(), result.getPlannedEndDate());
        Assertions.assertEquals(postApiResponse.getPlannedStartDate(), result.getPlannedStartDate());
        Assertions.assertEquals(postApiResponse.getCreatedAt(), result.getCreatedAt());
    }
}