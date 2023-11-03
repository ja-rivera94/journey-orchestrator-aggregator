package com.uniandes.journey.client;

import com.uniandes.journey.client.models.PostApiResponse;
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
public class PostClient {

    private final HttpClient httpClient;
    private final String URI = "/posts";


    public PostClient(@Client("posts") HttpClient httpClient) {
        this.httpClient = httpClient;

    }

    public Publisher<PostApiResponse> fetchPost(String authorization, Integer postId) {

        MutableHttpRequest<Object> request = HttpRequest.GET(URI.concat("/").concat(String.valueOf(postId)))
                .header(HttpHeaders.AUTHORIZATION, authorization)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        return httpClient.retrieve(request, Argument.of(PostApiResponse.class));
    }
}
