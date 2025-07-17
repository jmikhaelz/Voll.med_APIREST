package med.voll.api.model.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.person.Address;

@Table(name = "pacientes")
@Entity(name = "Paciente")

/* Metodos Lombok */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento_identidad;
    /* Incrutacion dentro de una entidad para @Embeddable */
    @Embedded
    private Address direccion;

    public Patient(DataPatient data) {
        this.id = null;
        this.nombre = data.nombre();
        this.email = data.email();
        this.telefono = data.telefono();
        this.documento_identidad = data.documento_identidad();
        this.direccion = new Address(data.direccion());
    }

}