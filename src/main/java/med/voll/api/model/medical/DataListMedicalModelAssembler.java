package med.voll.api.model.medical;

import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component // La anotación @Component indica que esta clase es un bean de Spring y se
           // registrará automáticamente en el contexto de la aplicación.
public class DataListMedicalModelAssembler
        implements RepresentationModelAssembler<DataListMedical, EntityModel<DataListMedical>> {

    // El metodo toModel convierte una instancia de DataListMedical en un
    // EntityModel,
    // que es una representación envolvente que proporciona una estructura estable
    // para el JSON y puede incluir links adicionales.
    @SuppressWarnings("null")
    @Override
    @NonNull
    public EntityModel<DataListMedical> toModel(@NonNull DataListMedical medicalData) {
        return EntityModel.of(medicalData);
    }
}
