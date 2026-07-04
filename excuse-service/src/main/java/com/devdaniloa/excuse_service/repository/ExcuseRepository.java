package com.devdaniloa.excuse_service.repository;

import com.devdaniloa.excuse_service.model.Excuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcuseRepository extends JpaRepository<Excuse, Long> {

    @Query(value = "SELECT * FROM excuses ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Excuse findRandom();

    @Query(value = "SELECT * FROM excuses WHERE category = :category ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Excuse findRandomByCategory(String category);
}
