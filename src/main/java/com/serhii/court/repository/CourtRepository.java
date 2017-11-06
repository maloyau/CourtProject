package com.serhii.court.repository;

import com.serhii.court.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository  extends JpaRepository<Court, Long> {
}
