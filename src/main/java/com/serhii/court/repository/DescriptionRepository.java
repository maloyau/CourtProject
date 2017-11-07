package com.serhii.court.repository;

import com.serhii.court.entity.Cause;
import com.serhii.court.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionRepository  extends JpaRepository<Description, Long> {
    List<Description> findByCause(Cause cause);
}
