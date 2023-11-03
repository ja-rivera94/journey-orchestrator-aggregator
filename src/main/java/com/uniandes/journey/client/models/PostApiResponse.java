package com.uniandes.journey.client.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostApiResponse {
    private String createdAt;
    private Double id;
    private String plannedEndDate;
    private String plannedStartDate;
    private Double routeId;
    private Double userId;
}
