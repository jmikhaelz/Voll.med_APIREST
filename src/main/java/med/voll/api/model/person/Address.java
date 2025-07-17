package med.voll.api.model.person;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*  Metodos Lombok */
@Getter
@NoArgsConstructor
@AllArgsConstructor

/* Incrustada dentro de una entidad por @Embedded */
@Embeddable
public class Address {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String codigo_postal;
    private String ciudad;
    private String estado;
}