package com.serhii.court.data.service.impl;

import com.serhii.court.data.model.CourtCase;
import com.serhii.court.data.repository.CourtCaseRepository;
import com.serhii.court.data.service.CourtCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtCaseServiceImpl implements CourtCaseService {

    @Autowired
    private CourtCaseRepository caseRepository;

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
