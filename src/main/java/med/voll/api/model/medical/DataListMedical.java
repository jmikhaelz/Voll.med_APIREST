package med.voll.api.model.medical;

public record DataListMedical(
        Long id,
        String nombre,
        String email,
        String documento,
        Specialty especialidad) {
}
