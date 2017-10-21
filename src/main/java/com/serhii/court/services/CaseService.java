package com.serhii.court.services;

import com.serhii.court.models.CourtCase;

import java.util.List;

public interface CaseService {
    void create(CourtCase c);
    void update(CourtCase c);
    CourtCase findOne(long id);
    List<CourtCase> findAll();
}
