package med.voll.api.model.medical;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.person.Address;

@Table(name = "medicos")
@Entity(name = "Medico")
/* Metodos Lombok */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Specialty especialidad;
    /* Incrutacion dentro de una entidad para @Embeddable */
    @Embedded
    private Address direccion;

    public Medical(DataMedical data) {
        this.id = null;
        this.nombre = data.nombre();
        this.email = data.email();
        this.telefono = data.telefono();
        this.documento = data.documento();
        this.especialidad = data.especialidad();
        this.direccion = new Address(data.direccion());
    }

}