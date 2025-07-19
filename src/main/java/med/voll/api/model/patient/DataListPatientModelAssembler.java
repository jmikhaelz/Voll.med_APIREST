package med.voll.api.model.patient;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;

@Component
public class DataListPatientModelAssembler
        implements RepresentationModelAssembler<DataListPatient, EntityModel<DataListPatient>> {
    @SuppressWarnings("null")
    @Override
    @NotNull
    public EntityModel<DataListPatient> toModel(@NotNull DataListPatient patientData) {
        return EntityModel.of(patientData);
    }

}
