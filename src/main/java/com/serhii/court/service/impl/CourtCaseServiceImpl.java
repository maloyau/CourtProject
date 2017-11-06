package com.serhii.court.service.impl;

import com.serhii.court.model.CourtCase;
import com.serhii.court.model.User;
import com.serhii.court.repository.CourtCaseRepository;
import com.serhii.court.service.CourtCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourtCaseServiceImpl implements CourtCaseService {

    @Autowired
    private CourtCaseRepository courtCaseRepository;

    @Override
    public CourtCase create(CourtCase courtCase) {
        return courtCaseRepository.saveAndFlush(courtCase);
    }

    @Override
    public CourtCase update(CourtCase courtCase) {
        return courtCaseRepository.saveAndFlush(courtCase);
    }

    @Override
    public void delete(CourtCase courtCase) {
        courtCaseRepository.delete(courtCase);
    }

    @Override
    public List<CourtCase> findAllByUser(User user) {
        return courtCaseRepository.findByUser(user);
    }

    @Override
    public List<CourtCase> findAll() {
        return courtCaseRepository.findAll();
    }
}
