package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.model.patient.DataListPatient;
import med.voll.api.model.patient.DataListPatientModelAssembler;
import med.voll.api.model.patient.DataPatient;
import med.voll.api.model.patient.DataUpdatePatient;
import med.voll.api.model.patient.Patient;
import med.voll.api.repository.PatientResp;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

@RestController
@RequestMapping("/pacientes")
public class PatientController {
    @Autowired
    private PatientResp respository;
    @Autowired
    private PagedResourcesAssembler<DataListPatient> pagedResourcesAssembler;
    @Autowired
    private DataListPatientModelAssembler DataListPatientModelAssembler;

    @Transactional
    @PostMapping
    public void set(@RequestBody @Valid DataPatient data) {
        respository.save(new Patient(data));
    }

    @GetMapping
    public PagedModel<EntityModel<DataListPatient>> getList(
            @PageableDefault(page = 0, size = 10, sort = { "nombre" }) Pageable paginacion) {
        Page<DataListPatient> pagina = respository.findAllByEstatusTrue(paginacion)
                .map(m -> new DataListPatient(
                        m.getId(),
                        m.getNombre(),
                        m.getEmail(),
                        m.getTelefono(),
                        m.getDocumento_identidad()));
        return pagedResourcesAssembler.toModel(pagina, DataListPatientModelAssembler);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DataUpdatePatient data) {
        var id_patient = respository.getReferenceById(data.id());
        id_patient.actualizarInformacion(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var paciente = respository.getReferenceById(id);
        paciente.disableStatus();
    }

}
