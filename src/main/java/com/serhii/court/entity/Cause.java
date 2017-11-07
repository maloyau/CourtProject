package com.serhii.court.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "causes")
public class Cause {
    private long causeId;
    private String number;
    private Set<Participant> participants;
    private String brief;
    private Court court;
    private Double price;
    private Date nextDate;
    private User user;

    @Id
    @Column(name = "cause_id", nullable = false)
    public long getCauseId() {
        return causeId;
    }

    public void setCauseId(long causeId) {
        this.causeId = causeId;
    }

    @Basic
    @Column(name = "cause_brief", nullable = true, length = 255)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "next_date", nullable = true)
    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 255)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "court_id", nullable = true)
    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    @ManyToMany
    @JoinTable(name = "causes_participants",
            joinColumns = @JoinColumn(name = "cause_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id", referencedColumnName = "participant_id"))
    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

}
