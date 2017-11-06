package com.serhii.court.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "descriptions", schema = "dbcourt", catalog = "")
public class Description {
    private long descriptionId;
    private Timestamp descriptionDate;
    private String descriptionText;
    private CourtCase courtCase;

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
    @Column(name = "description_text", nullable = false, length = 1024)
    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    public CourtCase getCourtCase() {
        return courtCase;
    }

    public void setCourtCase(CourtCase courtCase) {
        this.courtCase = courtCase;
    }


}
