package com.serhii.court.service.impl;

import com.serhii.court.entity.Cause;
import com.serhii.court.entity.User;
import com.serhii.court.repository.CauseRepository;
import com.serhii.court.service.CauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CauseServiceImpl implements CauseService {

    private CauseRepository causeRepository;

    @Autowired
    public CauseServiceImpl(CauseRepository causeRepository) {
        this.causeRepository = causeRepository;
    }

    @Override
    public Cause create(Cause cause) {
        return causeRepository.saveAndFlush(cause);
    }

    @Override
    public Cause update(Cause cause) {
        return causeRepository.saveAndFlush(cause);
    }

    @Override
    public void delete(Cause cause) {
        causeRepository.delete(cause);
    }

    @Override
    public List<Cause> findAllByUser(User user) {
        return causeRepository.findByUser(user);
    }

    @Override
    public List<Cause> findAll() {
        return causeRepository.findAll();
    }
}
