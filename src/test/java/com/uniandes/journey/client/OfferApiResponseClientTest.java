package com.uniandes.journey.client;

import com.uniandes.journey.client.models.OfferApiResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class OfferApiResponseClientTest {


    private OfferClient offerClient;
    @Mock
    private HttpClient httpClient;


    @Test
    void shouldCallPostEndpoint() {

        offerClient = new OfferClient(httpClient);
        Publisher<List<OfferApiResponse>> publisherResponse = Flowable.just(List.of(new OfferApiResponse()));
        String authorization = "xxxxxx";
        Integer postId = 2;

        Mockito.when(httpClient.retrieve(Mockito.any(), eq((Argument.listOf(OfferApiResponse.class))))).thenReturn(publisherResponse);
        offerClient.fetchOffers(authorization, postId);
        Mockito.verify(httpClient, Mockito.times(1)).retrieve(Mockito.any(), eq((Argument.listOf(OfferApiResponse.class))));

    }

}