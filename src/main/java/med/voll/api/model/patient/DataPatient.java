package med.voll.api.model.patient;

import med.voll.api.model.person.DataAddress;
/*
 * DTO Registro de Paciente/Cliente
 */
public record DataPatient(
    String nombre,
    String email,
    String telefono,
    String documento_identidad,
    DataAddress direccion
) {}
