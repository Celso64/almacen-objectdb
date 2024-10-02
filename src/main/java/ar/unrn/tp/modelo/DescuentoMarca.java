package ar.unrn.tp.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DescuentoMarca extends Descuento {

    @Id
    @GeneratedValue
    private Long id;

    private Marca marca;

    public DescuentoMarca(LocalDate fechaInicio, LocalDate fechaFin, Marca marca, Double porcentaje) {
        super(fechaInicio, fechaFin, porcentaje);
        this.marca = marca;
    }

    @Override
    public String marca() {
        return this.marca.getNombre();
    }

    @Override
    public Double calcularDescuento(Producto producto) {
        return (this.esMarca(producto.nombreMarca()))
                ? (super.calcularDescuento(producto.getPrecio(), super.getPorcentajeDescuento()))
                : 0.0;
    }

    @Override
    public Double calcularDescuento(String marca, Double precio) {
        return (this.esMarca(marca.toUpperCase()))
                ? (super.calcularDescuento(precio, super.getPorcentajeDescuento()))
                : precio;
    }

    public Boolean esMarca(String marca) {
        return this.marca.esMarca(marca.toUpperCase());
    }

    @Override
    public void agregarDescuentoMarca(List<DescuentoMarca> descuentoTarjetas) {
        descuentoTarjetas.add(this);
    }
}
