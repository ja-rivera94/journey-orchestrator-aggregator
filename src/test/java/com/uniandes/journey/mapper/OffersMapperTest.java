package com.uniandes.journey.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniandes.journey.client.models.OfferApiResponse;
import com.uniandes.journey.model.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.uniandes.journey.builder.ObjectsBuilder.buildOfferApiResponse;


class OffersMapperTest {
    private OffersMapper offersMapper;

    @Test
    void shouldMapOfferApiResponse() throws JsonProcessingException {
        offersMapper = new OffersMapper();
        OfferApiResponse offerApiResponse = buildOfferApiResponse();
        Offer result = offersMapper.map(offerApiResponse, 100.0);

        Assertions.assertEquals(offerApiResponse.getId().intValue(), result.getId());
        Assertions.assertEquals(offerApiResponse.getUserId().intValue(), result.getUserId());
        Assertions.assertEquals(offerApiResponse.getDescription(), result.getDescription());
        Assertions.assertEquals(offerApiResponse.getSize(), result.getSize());
        Assertions.assertEquals(offerApiResponse.getFragile(), result.getFragile());
        Assertions.assertEquals(offerApiResponse.getOffer(), result.getOffer());
        Assertions.assertEquals(offerApiResponse.getCreatedAt(), result.getCreatedAt());
        Assertions.assertNotNull(result.getScore());
    }
}