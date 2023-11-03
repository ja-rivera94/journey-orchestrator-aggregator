package com.uniandes.journey.client.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferApiResponse {
    private String createdAt;
    private String description;
    private Boolean fragile;
    private Double id;
    private Double offer;
    private Double postId;
    private String size;
    private Double userId;
}
