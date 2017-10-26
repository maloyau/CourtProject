package com.serhii.court.data.service;

import com.serhii.court.data.model.CourtCase;

import java.util.List;

public interface CourtCaseService {
    void create(CourtCase c);
    void update(CourtCase c);
    CourtCase findOne(long id);
    List<CourtCase> findAll();
}
