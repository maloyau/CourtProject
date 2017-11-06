package com.serhii.court.service;

import com.serhii.court.model.CourtCase;
import com.serhii.court.model.User;

import java.util.List;

public interface CourtCaseService {
    CourtCase create(CourtCase courtCase);
    CourtCase update(CourtCase courtCase);
    void delete(CourtCase courtCase);
    List<CourtCase> findAllByUser(User user);
    List<CourtCase> findAll();
}
