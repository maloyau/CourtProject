package com.serhii.court.repository;

import com.serhii.court.entity.Cause;

import com.serhii.court.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CauseRepository  extends JpaRepository<Cause, Long> {
    List<Cause> findByUser(User user);
}
