package med.voll.api.model.medical;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.person.DataAddress;

public record DataUpdateMedical(
        @NotNull Long id,
        String nombre,
        String telefono,
        DataAddress direccion) {
}