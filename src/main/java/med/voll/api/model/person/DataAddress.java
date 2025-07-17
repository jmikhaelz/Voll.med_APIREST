package med.voll.api.model.person;
/*
 * DTO Registro de Direccion de la Persona
 */
public record DataAddress(
    String calle,
    String numero,
    String complemento,
    String barrio,
    String codigo_postal,
    String ciudad,
    String estado
) {}
