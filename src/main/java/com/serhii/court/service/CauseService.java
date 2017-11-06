package com.serhii.court.service;

import com.serhii.court.entity.Cause;
import com.serhii.court.entity.User;

import java.util.List;

public interface CauseService {
    Cause create(Cause cause);
    Cause update(Cause cause);
    void delete(Cause cause);
    List<Cause> findAllByUser(User user);
    List<Cause> findAll();
}
