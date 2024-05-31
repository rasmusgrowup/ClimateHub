package com.climategroup.web.models;

import jakarta.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private String region;
    private String country;

//    @OneToMany(mappedBy = "location")
//    private List<ClimateData> climateData;
}

