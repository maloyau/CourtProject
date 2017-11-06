package com.serhii.court.model;

import javax.persistence.*;

@Entity
@Table(name = "courts", schema = "dbcourt", catalog = "")
public class Court {
    private long courtId;
    private String courtName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Court court = (Court) o;

        if (courtId != court.courtId) return false;
        if (courtName != null ? !courtName.equals(court.courtName) : court.courtName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (courtId ^ (courtId >>> 32));
        result = 31 * result + (courtName != null ? courtName.hashCode() : 0);
        return result;
    }
}
