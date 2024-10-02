package ar.unrn.tp.modelo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String codigo, descripcion;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Marca marca;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Categoria categoria;

    Double precio;

    public Producto(@NonNull String nombre, @NonNull String descripcion, @NonNull Marca marca, @NonNull Categoria categoria, @NonNull Double precio) {
        this.codigo = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
    }

    public void update(Producto productoNuevo) {
        this.codigo = productoNuevo.getCodigo();
        this.descripcion = productoNuevo.getDescripcion();
        this.marca = productoNuevo.getMarca();
        this.categoria = productoNuevo.getCategoria();
        this.precio = productoNuevo.getPrecio();
    }

    public String nombreMarca() {
        return this.marca.getNombre().toUpperCase();
    }
}
