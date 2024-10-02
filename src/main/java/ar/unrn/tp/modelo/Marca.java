package ar.unrn.tp.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Marca(String nombre) {
        if (nombre.isBlank()) throw new IllegalArgumentException("Nombre Vacio");
        this.nombre = nombre.toUpperCase();
    }

    public Boolean esMarca(String marcaNombre) {
        return this.nombre.equalsIgnoreCase(marcaNombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca marca)) return false;
        return Objects.equals(id, marca.id) && nombre.equalsIgnoreCase(marca.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
