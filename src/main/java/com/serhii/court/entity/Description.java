package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "descriptions")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id", nullable = false)
    private long descriptionId;
    @Basic
    @Column(name = "description_date", nullable = false)
    private Date descriptionDate;
    @Basic
    @Column(name = "description_text", nullable = false, columnDefinition = "text")
    private String descriptionText;
    @ManyToOne
    @JoinColumn(name = "cause_id", nullable = false)
    private Cause cause;
}
