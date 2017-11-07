package com.serhii.court.dto;

import lombok.Data;

@Data
public class DecisionDto {
    private long decisionId;
    private String decisionBrief;
    private String decisionText;
    private String decisionDate;
    private String cause;
}
