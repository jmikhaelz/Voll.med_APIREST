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
    private Boolean estatus;
    private String nombre;
    private String email;
    private String telefono;
    private String documento_identidad;
    /* Incrutacion dentro de una entidad para @Embeddable */
    @Embedded
    private Address direccion;

    public Patient(DataPatient data) {
        this.id = null;
        this.estatus = true;
        this.nombre = data.nombre();
        this.email = data.email();
        this.telefono = data.telefono();
        this.documento_identidad = data.documento_identidad();
        this.direccion = new Address(data.direccion());
    }

    public void disableStatus() {
        this.estatus = false;
    }

    public void actualizarInformacion(DataUpdatePatient data) {
        if (data == null)
            return;

        if (data.nombre() != null && !data.nombre().isBlank())
            this.nombre = data.nombre();

        if (data.telefono() != null && !data.telefono().isBlank())
            this.telefono = data.telefono();

        if (data.direccion() != null) {
            if (this.direccion == null) {
                this.direccion = new Address();
            }
            this.direccion.update(data.direccion());
        }
    }

}