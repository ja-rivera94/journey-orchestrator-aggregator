package com.uniandes.journey.mapper;

import com.uniandes.journey.client.models.OfferApiResponse;
import com.uniandes.journey.model.Offer;
import com.uniandes.journey.model.SizeEnum;
import jakarta.inject.Singleton;

import java.util.function.BiFunction;

@Singleton
public class OffersMapper {

    private static final BiFunction<OfferApiResponse, Double, Double> CALCULATE_SCORE = (input, bagCost) -> {
        SizeEnum size = SizeEnum.getValue(input.getSize());
        return input.getOffer() - (size.getPercentage() / 100 * bagCost);
    };

    public Offer map(OfferApiResponse input, Double bagCost) {
        return Offer.builder()
                .id(input.getId().intValue())
                .userId(input.getUserId().intValue())
                .description(input.getDescription())
                .size(input.getSize())
                .fragile(input.getFragile())
                .offer(input.getOffer())
                .score(CALCULATE_SCORE.apply(input, bagCost))
                .createdAt(input.getCreatedAt())
                .build();
    }
}
