package com.serhii.court.repository;

import com.serhii.court.entity.Cause;
import com.serhii.court.entity.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Long> {
    List<Decision> findByCause(Cause cause);
}
