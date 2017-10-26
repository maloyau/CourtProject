package com.serhii.court.data.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotEmpty(message = "Вкажіть номер судової справи")
    private String numberCase;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "court_id")
    @NotEmpty(message = "Вкажіть суд в якому розглядається справа")
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
    @NotEmpty(message = "Вкажіть дату наступного розгляду")
    private Date nextReviewDate;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;
}
