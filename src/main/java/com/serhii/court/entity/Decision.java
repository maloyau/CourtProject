package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "decisions")
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decision_id", nullable = false)
    private long decisionId;
    @Basic
    @Column(name = "decision_brief", nullable = false)
    private String decisionBrief;
    @Basic
    @Column(name = "decision_text", nullable = false, columnDefinition = "text")
    private String decisionText;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "decision_date", nullable = false)
    private Date decisionDate;
    @ManyToOne
    @JoinColumn(name = "cause_id", nullable = false)
    private Cause cause;
}
