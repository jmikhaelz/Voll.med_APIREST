package med.voll.api.model.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/*
 * DTO Registro de Direccion de la Persona
 */
public record DataAddress(
        @NotBlank String calle,
        @NotBlank String numero,
        String complemento,
        @NotBlank String barrio,
        @NotBlank @Pattern(regexp = "\\d{5}") String codigo_postal,
        @NotBlank String ciudad,
        @NotBlank String estado) {
}
