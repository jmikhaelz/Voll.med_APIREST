package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.model.medical.DataListMedical;
import med.voll.api.model.medical.DataListMedicalModelAssembler;
import med.voll.api.model.medical.DataMedical;
import med.voll.api.model.medical.Medical;
import med.voll.api.repository.MedicalResp;
import med.voll.api.model.medical.DataUpdateMedical;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/medicos")
public class MedicalController {
    @Autowired
    private MedicalResp respository;

    // Dentro de MedicoController
    @Autowired // PagedResourcesAssembler se usa para convertir una Page en un PagedModel.
    private PagedResourcesAssembler<DataListMedical> pagedResourcesAssembler;
    @Autowired // Inyectamos nuestro DataListMedicalModelAssembler para convertir
               // DataListMedical en EntityModel.
    private DataListMedicalModelAssembler DataListMedicalModelAssembler;

    @Transactional
    @PostMapping
    public ResponseEntity<Object> set(@RequestBody @Valid DataMedical data, UriComponentsBuilder uri) {
        var medical = new Medical(data);
        respository.save(medical);

        var location = uri.path("/medicos/{id}")
                        .buildAndExpand(medical.getId())
                        .toUri();

        return ResponseEntity.created(location).body(
            new DataListMedical(
                medical.getId(),
                medical.getNombre(),
                medical.getEmail(),
                medical.getDocumento(),
                medical.getEspecialidad()
            )
        );
    }

    @GetMapping("")
    public ResponseEntity<PagedModel<EntityModel<DataListMedical>>> getList(
            @PageableDefault(size = 10, sort = { "nombre" }) Pageable paginacion) {
        Page<DataListMedical> pagina = respository.findAllByEstatusTrue(paginacion)
                .map(m -> new DataListMedical(
                        m.getId(),
                        m.getNombre(),
                        m.getEmail(),
                        m.getDocumento(),
                        m.getEspecialidad()));
        // Usamos el pagedResourcesAssembler y el DataListMedicalModelAssembler para
        // convertir la Page en un PagedModel.
        // Esto garantiza que cada objeto DataListMedical sea envuelto en un
        // EntityModel, proporcionando una estructura JSON estable y permitiendo añadir
        // links adicionales.
        var page = pagedResourcesAssembler.toModel(pagina, DataListMedicalModelAssembler);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid DataUpdateMedical data) {
        var id_med = respository.getReferenceById(data.id());
        id_med.update(data);
        return ResponseEntity.ok(new DataListMedical(
                id_med.getId(),
                id_med.getNombre(),
                id_med.getEmail(),
                id_med.getDocumento(),
                id_med.getEspecialidad()));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var medical_rep = respository.getReferenceById(id);
        medical_rep.disableStatus();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> about(@PathVariable Long id) {
        var id_med = respository.getReferenceById(id);
        return ResponseEntity.ok(new DataListMedical(
                        id_med.getId(),
                        id_med.getNombre(),
                        id_med.getEmail(),
                        id_med.getDocumento(),
                        id_med.getEspecialidad()));
    }
}
