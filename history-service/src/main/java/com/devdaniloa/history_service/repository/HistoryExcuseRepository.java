package com.devdaniloa.history_service.repository;

import com.devdaniloa.history_service.model.HistoryExcuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryExcuseRepository extends JpaRepository<HistoryExcuse, Long> {
    List<HistoryExcuse> findAllByOrderByUsedAtDesc(Long userId);
}
