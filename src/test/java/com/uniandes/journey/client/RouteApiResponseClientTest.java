package com.uniandes.journey.client;

import com.uniandes.journey.client.models.RouteApiResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class RouteApiResponseClientTest {

    private RouteClient routeClient;
    @Mock
    private HttpClient httpClient;


    @Test
    void shouldCallPostEndpoint() {

        routeClient = new RouteClient(httpClient);
        Publisher<RouteApiResponse> publisherResponse = Flowable.just(new RouteApiResponse());
        String authorization = "xxxxxx";
        Integer postId = 2;

        Mockito.when(httpClient.retrieve(Mockito.any(), eq((Argument.of(RouteApiResponse.class))))).thenReturn(publisherResponse);
        routeClient.fetchRoute(authorization, postId);
        Mockito.verify(httpClient, Mockito.times(1)).retrieve(Mockito.any(), eq((Argument.of(RouteApiResponse.class))));

    }
}