package com.serhii.court.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "descriptions")
public class Description {
    private long descriptionId;
    private Timestamp descriptionDate;
    private String descriptionText;
    private Cause cause;

    @Id
    @Column(name = "description_id", nullable = false)
    public long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(long descriptionId) {
        this.descriptionId = descriptionId;
    }

    @Basic
    @Column(name = "description_date", nullable = false)
    public Timestamp getDescriptionDate() {
        return descriptionDate;
    }

    public void setDescriptionDate(Timestamp descriptionDate) {
        this.descriptionDate = descriptionDate;
    }

    @Basic
    @Column(name = "description_text", nullable = false, length = -1)
    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    @ManyToOne
    @JoinColumn(name = "cause_id", nullable = false)
    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause causeId) {
        this.cause = cause;
    }

}
