package com.uniandes.journey.client;

import com.uniandes.journey.client.models.PostApiResponse;
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
class PostApiResponseClientTest {

    private PostClient postClient;
    @Mock
    private HttpClient httpClient;


    @Test
    void shouldCallPostEndpoint() {

        postClient = new PostClient(httpClient);
        Publisher<PostApiResponse> publisherResponse = Flowable.just(new PostApiResponse());
        String authorization = "xxxxxx";
        Integer postId = 2;

        Mockito.when(httpClient.retrieve(Mockito.any(), eq((Argument.of(PostApiResponse.class))))).thenReturn(publisherResponse);
        postClient.fetchPost(authorization, postId);
        Mockito.verify(httpClient, Mockito.times(1)).retrieve(Mockito.any(), eq((Argument.of(PostApiResponse.class))));

    }
}