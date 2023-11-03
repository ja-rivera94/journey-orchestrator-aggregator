package com.uniandes.journey.mapper;

public interface Mapper<I, O> {
    O map(I input);
}
