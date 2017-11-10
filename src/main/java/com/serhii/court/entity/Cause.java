package com.serhii.court.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "causes")
public class Cause extends AbstractEntity {
    @Basic
    @Column(name = "number", nullable = false, length = 255)
    private String number;
    @ManyToMany
    @JoinTable(name = "causes_participants",
            joinColumns = @JoinColumn(name = "cause_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id", referencedColumnName = "id"))
    private Set<Participant> participants;
    @Basic
    @Column(name = "contract", nullable = true, length = 255)
    private String contract;
    @Basic
    @Column(name = "brief", nullable = true, length = 255)
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
