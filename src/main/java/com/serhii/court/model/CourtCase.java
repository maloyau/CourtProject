package com.serhii.court.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cases", schema = "dbcourt", catalog = "")
public class CourtCase {
    private long caseId;
    private Timestamp nextReviewDate;
    private String number;
    private Double price;
    private User user;
    private Court court;

    @Id
    @Column(name = "case_id", nullable = false)
    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    @Basic
    @Column(name = "next_review_date", nullable = true)
    public Timestamp getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(Timestamp nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
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

}
