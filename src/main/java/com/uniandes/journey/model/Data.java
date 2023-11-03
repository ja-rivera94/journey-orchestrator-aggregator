package com.uniandes.journey.model;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;


@Getter
@Builder
public class Data {
    private Integer id;
    private Route route;
    private String plannedStartDate;
    private String plannedEndDate;
    private String createdAt;
    private ArrayList<Offer> offers;
}
