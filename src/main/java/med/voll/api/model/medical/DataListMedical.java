package med.voll.api.model.medical;

public record DataListMedical(
        String nombre,
        String email,
        String documento,
        Specialty especialidad) {
}
