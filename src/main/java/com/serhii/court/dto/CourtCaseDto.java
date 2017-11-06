package com.serhii.court.dto;

import com.serhii.court.model.*;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Data
public class CourtCaseDto {
    private long caseId;
    private User user;
    private String numberCase;
    private Court court;
    private Set<Description> descriptions;
    private double price;
    private Date nextReviewDate;
}
