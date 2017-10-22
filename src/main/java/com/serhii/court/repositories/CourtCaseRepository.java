package com.serhii.court.repositories;

import com.serhii.court.models.CourtCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtCaseRepository extends JpaRepository<CourtCase, Long> {
}
