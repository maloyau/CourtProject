package com.serhii.court.entity;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {
    private long participantId;
    private String participantName;
    private String participantAddress;

    @Id
    @Column(name = "participant_id", nullable = false)
    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    @Basic
    @Column(name = "participant_name", nullable = false, length = 255)
    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    @Basic
    @Column(name = "participant_address", nullable = true, length = 255)
    public String getParticipantAddress() {
        return participantAddress;
    }

    public void setParticipantAddress(String participantAddress) {
        this.participantAddress = participantAddress;
    }

}
