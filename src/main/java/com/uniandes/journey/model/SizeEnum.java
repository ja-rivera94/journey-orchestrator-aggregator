package com.uniandes.journey.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SizeEnum {
    LARGE("LARGE", 100),
    MEDIUM("MEDIUM", 50),
    SMALL("SMALL", 25);

    private final String key;
    private final Integer percentage;

    public static SizeEnum getValue(String key) {
        return Arrays.stream(SizeEnum.values())
                .filter(sizeEnum -> sizeEnum.key.equals(key))
                .findFirst().get();
    }
}
