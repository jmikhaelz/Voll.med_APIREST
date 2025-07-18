package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.model.medical.DataListMedical;
import med.voll.api.model.medical.DataListMedicalModelAssembler;
import med.voll.api.model.medical.DataMedical;
import med.voll.api.model.medical.Medical;
import med.voll.api.repository.MedicalResp;
import med.voll.api.model.medical.DataUpdateMedical;
//En la seccion de imports:
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

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
    public void set(@RequestBody @Valid DataMedical data) {
        respository.save(new Medical(data));
    }

    @GetMapping
    public PagedModel<EntityModel<DataListMedical>> getList(
            @PageableDefault(size = 10, sort = { "nombre" }) Pageable paginacion) {
        Page<DataListMedical> pagina = respository.findAll(paginacion)
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
        return pagedResourcesAssembler.toModel(pagina, DataListMedicalModelAssembler);
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody @Valid DataUpdateMedical data) {
        var id_med = respository.getReferenceById(data.id());
        id_med.update(data);
    }
}
