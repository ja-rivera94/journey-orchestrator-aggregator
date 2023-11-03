package com.uniandes.journey.mapper;

import com.uniandes.journey.client.models.PostApiResponse;
import com.uniandes.journey.model.Data;
import com.uniandes.journey.model.Offer;
import com.uniandes.journey.model.Route;
import jakarta.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class DataMapper {

    public Data map(PostApiResponse postApiResponse, Route route, ArrayList<Offer> listOffer){

        return Data.builder()
                .id(postApiResponse.getId().intValue())
                .route(route)
                .plannedEndDate(postApiResponse.getPlannedEndDate())
                .plannedStartDate(postApiResponse.getPlannedStartDate())
                .createdAt(postApiResponse.getCreatedAt())
                .offers(listOffer)
                .build();
    }
}
