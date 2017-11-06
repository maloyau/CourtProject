package com.serhii.court.entity;

import javax.persistence.*;

@Entity
@Table(name = "courts")
public class Court {
    private long courtId;
    private String courtName;
    private String courtAddress;

    @Id
    @Column(name = "court_id", nullable = false)
    public long getCourtId() {
        return courtId;
    }

    public void setCourtId(long courtId) {
        this.courtId = courtId;
    }

    @Basic
    @Column(name = "court_name", nullable = false, length = 255)
    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    @Basic
    @Column(name = "court_address", nullable = true, length = 255)
    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }

}
