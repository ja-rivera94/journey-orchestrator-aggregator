package com.uniandes.journey.controller;

import com.uniandes.journey.model.Data;
import com.uniandes.journey.service.PostService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.reactivex.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PostControllerTest {


    @Mock
    private PostService postService;
    private PostController postController;


    @BeforeEach
    void init() {
        postController = new PostController(postService);
    }

    @Test
    void givenAPostWhenIsFoundThenShouldReturnPost() {

        String authorization = "xxxxxx";
        Integer postId = 2;
        Single<Data> singleData = Single.just(Data.builder().id(postId).build());
        Mockito.when(postService.getPost(authorization, postId)).thenReturn(singleData);

        MutableHttpResponse<Data> response = postController.get(postId, authorization).blockingGet();
        Assertions.assertEquals(singleData.blockingGet().getId(), response.getBody().get().getId());
        Assertions.assertEquals(HttpStatus.CREATED.getCode(), response.status().getCode());

    }

    @Test
    void givenAPostWhenIsNotAuthenticatedThenShouldReturn4012() {

        String authorization = "xxxxxx";
        Integer postId = 2;

        Mockito.doThrow(new HttpClientResponseException("UNAUTHORIZED", HttpResponse.badRequest())).when(postService).getPost(authorization, postId);

        HttpClientResponseException thrown = Assertions.assertThrows(HttpClientResponseException.class, () -> {
            postController.get(postId, authorization).blockingGet();
        });
        Assertions.assertEquals("UNAUTHORIZED",thrown.getMessage());

    }

}