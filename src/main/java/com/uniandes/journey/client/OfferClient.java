package com.uniandes.journey.client;

import com.uniandes.journey.client.models.OfferApiResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.util.List;

@Singleton
public class OfferClient {

    private final HttpClient httpClient;
    private final String URI = "/offers";


    public OfferClient(@Client("offers") HttpClient httpClient) {
        this.httpClient = httpClient;

    }

    public Publisher<List<OfferApiResponse>> fetchOffers(String authorization, Integer postId) {

        MutableHttpRequest<Object> request = HttpRequest.GET(URI.concat("?post=").concat(String.valueOf(postId)))
                .header(HttpHeaders.AUTHORIZATION, authorization)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        return httpClient.retrieve(request, Argument.listOf(OfferApiResponse.class));
    }
}
