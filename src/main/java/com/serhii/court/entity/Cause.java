package com.serhii.court.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "causes")
public class Cause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cause_id", nullable = false)
    private long causeId;
    @Basic
    @Column(name = "number", nullable = false, length = 255)
    private String number;
    @ManyToMany
    @JoinTable(name = "causes_participants",
            joinColumns = @JoinColumn(name = "cause_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id", referencedColumnName = "participant_id"))
    private Set<Participant> participants;
    @Basic
    @Column(name = "cause_brief", nullable = true, length = 255)
    private String brief;
    @ManyToOne
    @JoinColumn(name = "court_id", nullable = true)
    private Court court;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "next_date", nullable = true)
    private Date nextDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;
}
