package com.example.restapi.repository;

import com.example.restapi.model.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterDataRepository extends JpaRepository<MeterData, Long> {
    boolean existsByContractNumberAndMeterNumber(String contractNumber, String meterNumber);
}

