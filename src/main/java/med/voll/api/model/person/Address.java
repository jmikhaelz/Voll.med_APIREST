package med.voll.api.model.person;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
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

    public Address(DataAddress data) {
        this.calle = data.calle();
        this.numero = data.numero();
        this.complemento = data.complemento();
        this.barrio = data.barrio();
        this.codigo_postal = data.codigo_postal();
        this.ciudad = data.ciudad();
        this.estado = data.estado();
    }

    public void update(@Valid DataAddress direccion) {
        if (direccion == null)
            return;

        if (direccion.calle() != null && !direccion.calle().isBlank()) {
            this.calle = direccion.calle();
        }

        if (direccion.numero() != null && !direccion.numero().isBlank()) {
            this.numero = direccion.numero();
        }

        if (direccion.complemento() != null && !direccion.complemento().isBlank()) {
            this.complemento = direccion.complemento();
        }

        if (direccion.barrio() != null && !direccion.barrio().isBlank()) {
            this.barrio = direccion.barrio();
        }

        if (direccion.codigo_postal() != null && !direccion.codigo_postal().isBlank()) {
            this.codigo_postal = direccion.codigo_postal();
        }

        if (direccion.ciudad() != null && !direccion.ciudad().isBlank()) {
            this.ciudad = direccion.ciudad();
        }

        if (direccion.estado() != null && !direccion.estado().isBlank()) {
            this.estado = direccion.estado();
        }
    }

}