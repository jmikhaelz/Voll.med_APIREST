package med.voll.api.model.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.person.DataAddress;

public record DataUpdatePatient(
                @NotNull Long id,
                String nombre,
                @Email String email,
                String telefono,
                DataAddress direccion) {
}
