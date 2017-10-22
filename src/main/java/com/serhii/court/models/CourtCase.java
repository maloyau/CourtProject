package com.serhii.court.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "cases")
@Data
public class CourtCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User responsibleEmployee;
    private String numberCase;
    @ManyToOne(fetch = FetchType.LAZY)
    private Court court;
    @ElementCollection
    @CollectionTable(name = "descriptions")
    @MapKeyColumn(name = "description_date")
    @Column(name = "description_text")
    private Map<Date, String> descriptionMap;
    private double priceOfClaim;
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextReviewDate;
    private State state;
}
