package com.uniandes.journey.controller;

import com.uniandes.journey.model.Data;
import com.uniandes.journey.service.PostService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpResponseFactory;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/public/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @Get("/{id}")
    public Single<MutableHttpResponse<Data>> get(@PathVariable("id") Integer postId, @Header("Authorization") String authorizationHeader) {
        return postService.getPost(authorizationHeader, postId)
                .map(data -> HttpResponse.ok(data).status(HttpStatus.CREATED))
                .onErrorResumeNext(throwable -> {
                    log.error("There was an error {}", throwable.getMessage());
                    if (throwable.getMessage().contains("UNAUTHORIZED"))
                        return Single.just(HttpResponseFactory.INSTANCE.status(HttpStatus.PRECONDITION_FAILED));
                    return Single.just(HttpResponse.serverError());
                });
    }
}
