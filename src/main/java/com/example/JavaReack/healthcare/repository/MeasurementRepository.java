package com.example.JavaReack.healthcare.repository;

import com.example.JavaReack.healthcare.model.BloodPressureMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<BloodPressureMeasurement, Long> {
}
