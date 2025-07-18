package med.voll.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.medical.Medical;

public interface MedicalResp extends JpaRepository<Medical, Long> {

    Page<Medical> findAllByEstatusTrue(Pageable paginacion);

}
