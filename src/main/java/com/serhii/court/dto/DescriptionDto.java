package com.serhii.court.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DescriptionDto {
    private long descriptionId;
    private String description_text;
    private Date date;
}
