package com.serhii.court.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "decisions")
public class Decision extends AbstractEntity{
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
    @JoinColumn(name = "cause_id", referencedColumnName = "id", nullable = false)
    private Cause cause;
}
