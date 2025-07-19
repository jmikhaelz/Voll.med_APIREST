package med.voll.api.model.patient;

public record DataListPatient(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento_identidad) {
}
