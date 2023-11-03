package com.uniandes.journey.service;

import com.uniandes.journey.client.OfferClient;
import com.uniandes.journey.client.PostClient;
import com.uniandes.journey.client.RouteClient;
import com.uniandes.journey.client.models.RouteApiResponse;
import com.uniandes.journey.mapper.DataMapper;
import com.uniandes.journey.mapper.Mapper;
import com.uniandes.journey.mapper.OffersMapper;
import com.uniandes.journey.model.Data;
import com.uniandes.journey.model.Offer;
import com.uniandes.journey.model.Route;
import io.reactivex.Single;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final OfferClient offerClient;
    private final PostClient postClient;
    private final RouteClient routeClient;
    private final Mapper<RouteApiResponse, Route> routesMapper;
    private final OffersMapper offersMapper;
    private final DataMapper dataMapper;

    public Single<Data> getPost(String authorization, Integer postId) {
        return Single.fromPublisher(postClient.fetchPost(authorization, postId))
                .flatMap(postApiResponse ->
                        Single.fromPublisher(routeClient.fetchRoute(authorization, postApiResponse.getRouteId().intValue()))
                                .flatMap(routeApiResponse -> Single.fromPublisher(offerClient.fetchOffers(authorization, postId))
                                        .map(offerApiResponseList ->
                                                offerApiResponseList.stream()
                                                        .map(offerApiResponse -> offersMapper.map(offerApiResponse, routeApiResponse.getBagCost()))
                                                        .sorted(Comparator.comparingDouble(Offer::getScore).reversed())
                                                        .collect(Collectors.toCollection(ArrayList::new))
                                        )
                                        .map(offers ->
                                                dataMapper.map(postApiResponse, routesMapper.map(routeApiResponse), offers)
                                        )
                                )
                );
    }
}
