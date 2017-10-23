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
    @Column(name = "case_id")
    private long caseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User responsibleEmployee;
    @Column(name = "number_case")
    private String numberCase;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "court_id")
    private Court court;
    @ElementCollection
    @CollectionTable(name = "descriptions")
    @MapKeyColumn(name = "description_date")
    @Column(name = "description_text")
    private Map<Date, String> descriptionMap;
    @Column(name = "price")
    private double priceOfClaim;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "next_review_date")
    private Date nextReviewDate;
    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    private State state;
}
