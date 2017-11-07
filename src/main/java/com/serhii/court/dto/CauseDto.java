package com.serhii.court.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CauseDto {
    private long causeId;
    private String number;
    private Set<String> participants;
    private String topic;
    private String court;
    private Double price;
    private Date nextDate;
    private String user;
}
