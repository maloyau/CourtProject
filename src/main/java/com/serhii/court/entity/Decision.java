package com.serhii.court.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "decisions")
public class Decision {
    private long decisionId;
    private String decisionBrief;
    private String decisionText;
    private Date decisionDate;
    private Cause cause;

    @Id
    @Column(name = "decision_id", nullable = false)
    public long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(long decisionId) {
        this.decisionId = decisionId;
    }

    @Basic
    @Column(name = "decision_brief", nullable = false)
    public String getDecisionBrief() {
        return decisionBrief;
    }

    public void setDecisionBrief(String decisionBrief) {
        this.decisionBrief = decisionBrief;
    }

    @Basic
    @Column(name = "decision_text", nullable = false, length = -1)
    public String getDecisionText() {
        return decisionText;
    }

    public void setDecisionText(String decisionText) {
        this.decisionText = decisionText;
    }

    @Basic
    @Column(name = "decision_date", nullable = false)
    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    @ManyToOne
    @JoinColumn(name = "cause_id", nullable = false)
    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }
}
