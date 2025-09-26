package com.dadry.universityproject.repository;

import com.dadry.universityproject.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> findByNameContainingIgnoreCase(String namePart);
}
