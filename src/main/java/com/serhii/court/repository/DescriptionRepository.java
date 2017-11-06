package com.serhii.court.repository;

import com.serhii.court.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository  extends JpaRepository<Description, Long> {
}
