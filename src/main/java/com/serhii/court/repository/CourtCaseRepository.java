package com.serhii.court.repository;

import com.serhii.court.model.CourtCase;
import com.serhii.court.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourtCaseRepository  extends JpaRepository<CourtCase, Long> {
    List<CourtCase> findByUser(User user);
}
