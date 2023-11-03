package com.uniandes.journey.client;

import com.uniandes.journey.client.models.RouteApiResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class RouteClient {

    private final HttpClient httpClient;
    private final String URI = "/routes";


    public RouteClient(@Client("routes") HttpClient httpClient) {
        this.httpClient = httpClient;

    }

    public Publisher<RouteApiResponse> fetchRoute(String authorization, Integer routeId) {

        MutableHttpRequest<Object> request = HttpRequest.GET(URI.concat("/").concat(String.valueOf(routeId)))
                .header(HttpHeaders.AUTHORIZATION, authorization)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        return httpClient.retrieve(request, Argument.of(RouteApiResponse.class));
    }
}
