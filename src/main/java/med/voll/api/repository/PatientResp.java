package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.patient.Patient;

public interface PatientResp extends JpaRepository<Patient, Long> {

}
