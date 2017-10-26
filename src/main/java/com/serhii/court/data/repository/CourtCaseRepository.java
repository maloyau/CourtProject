package com.serhii.court.data.repository;

import com.serhii.court.data.model.CourtCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtCaseRepository extends JpaRepository<CourtCase, Long> {
}
