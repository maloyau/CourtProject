package com.serhii.court.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "descriptions")
public class Description extends AbstractEntity{
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
