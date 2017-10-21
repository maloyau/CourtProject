package com.serhii.courtproject.services.impl;

import com.serhii.courtproject.models.CourtCase;
import com.serhii.courtproject.repositories.CaseRepository;
import com.serhii.courtproject.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService{

    @Autowired
    private CaseRepository caseRepository;

    public void create(CourtCase c) {
        caseRepository.save(c);
    }

    public void update(CourtCase c) {
        caseRepository.save(c);
    }

    public CourtCase findOne(long id) {
        return caseRepository.findOne(id);
    }

    public List<CourtCase> findAll() {
        return caseRepository.findAll();
    }
}
