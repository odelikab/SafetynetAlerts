package com.openclassrooms.safetynetalerts.repositery;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.safetynetalerts.model.MedicalRecord;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long>{

}
