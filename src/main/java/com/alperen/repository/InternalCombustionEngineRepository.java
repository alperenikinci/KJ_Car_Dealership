package com.alperen.repository;

import com.alperen.entity.ElectricEngine;
import com.alperen.entity.InternalCombustionEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalCombustionEngineRepository extends JpaRepository<InternalCombustionEngine,Long> {
}
