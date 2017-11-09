package com.serhii.court.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "participants")
public class Participant extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id", nullable = false)
    private long participantId;
    @Basic
    @Column(name = "participant_name", nullable = false, length = 255)
    private String participantName;
    @Basic
    @Column(name = "participant_address", nullable = true, length = 255)
    private String participantAddress;
}
