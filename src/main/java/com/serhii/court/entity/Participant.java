package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "participants")
public class Participant {
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
