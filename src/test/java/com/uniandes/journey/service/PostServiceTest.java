package com.uniandes.journey.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uniandes.journey.client.OfferClient;
import com.uniandes.journey.client.PostClient;
import com.uniandes.journey.client.RouteClient;
import com.uniandes.journey.client.models.OfferApiResponse;
import com.uniandes.journey.client.models.PostApiResponse;
import com.uniandes.journey.client.models.RouteApiResponse;
import com.uniandes.journey.mapper.DataMapper;
import com.uniandes.journey.mapper.Mapper;
import com.uniandes.journey.mapper.OffersMapper;
import com.uniandes.journey.model.Data;
import com.uniandes.journey.model.Route;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;

import java.util.List;

import static com.uniandes.journey.builder.ObjectsBuilder.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {


    @Mock
    private OfferClient offerClient;
    @Mock
    private PostClient postClient;
    @Mock
    private RouteClient routeClient;
    @Mock
    private Mapper<RouteApiResponse, Route> routesMapper;
    private OffersMapper offersMapper;
    private DataMapper dataMapper;
    private PostService postService;

    @BeforeEach
    void init() {
        dataMapper = new DataMapper();
        offersMapper = new OffersMapper();
        postService = new PostService(offerClient, postClient, routeClient, routesMapper, offersMapper, dataMapper);
    }


    @Test
    void shouldCollectAndMapPost() throws JsonProcessingException {

        String authorization = "xxxxxx";
        Integer postId = 2;

        Publisher<PostApiResponse> postApiResponsePublisher = Flowable.just(buildPostApiResponse());
        Publisher<List<OfferApiResponse>> offerApiResponsePublisher = Flowable.just(List.of(buildOfferApiResponse()));
        Publisher<RouteApiResponse> routeApiResponsePublisher = Flowable.just(buildRouteApiResponse());


        Mockito.when(postClient.fetchPost(authorization, postId)).thenReturn(postApiResponsePublisher);
        Mockito.when(routeClient.fetchRoute(authorization, buildPostApiResponse().getRouteId().intValue())).thenReturn(routeApiResponsePublisher);
        Mockito.when(offerClient.fetchOffers(authorization, postId)).thenReturn(offerApiResponsePublisher);

        Data result = postService.getPost(authorization, postId).blockingGet();

        Assertions.assertEquals(postId, result.getId());
        Mockito.verify(postClient, Mockito.times(1)).fetchPost(authorization, postId);
        Mockito.verify(routeClient, Mockito.times(1)).fetchRoute(authorization, buildPostApiResponse().getRouteId().intValue());
        Mockito.verify(offerClient, Mockito.times(1)).fetchOffers(authorization, postId);
    }

}