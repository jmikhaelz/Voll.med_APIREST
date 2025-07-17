package med.voll.api.model.medical;

import med.voll.api.model.person.DataAddress;
/*
 * DTO Registro de Medico/Doctor
 */
public record DataMedical(
    String nombre,
    String email,
    String telefono,
    String documento,
    Specialty especialidad,
    DataAddress direccion
) {}
