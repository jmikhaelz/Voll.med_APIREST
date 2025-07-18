package med.voll.api.model.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.medical.Specialty;
import med.voll.api.model.person.DataAddress;

/*
 * DTO Registro de Paciente/Cliente
 */
public record DataPatient(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\+d{2,4}\\s?\\d{3}-\\d{2}-\\d{2}-\\d{2}") String telefono,
        @NotBlank @Pattern(regexp = "\\d{7,9}") String documento_identidad,
        @NotNull Specialty especialidad,
        @NotNull @Valid DataAddress direccion) {
}
