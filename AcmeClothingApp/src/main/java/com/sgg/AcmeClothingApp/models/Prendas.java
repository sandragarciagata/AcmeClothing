package com.sgg.AcmeClothingApp.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * prendaId -> referencia alfanumérica de 10 caracteres 1er caracter Talla:
 * S-M-L El identificador es único aunque se trate del mismo modelo de prenda,
 * Precio en € con dos decimales. Precio promocinado: aplicando todas las
 * promociones. Asociadas a 0 o + categorias: "Mujer", "Hombre", "Accesorios",
 * "Pantalones", “Camisetas”, “Zapatos”, “Zapatillas”.
 */

@Entity
@Table(name = "prendas")
public class Prendas {

    public enum Categoria {
        Mujer, Hombre, Accesorios, Pantalones, Camisetas, Zapatos, Zapatillas;
    }

    // Atributos Prenda
    @Id
    @Pattern(regexp = "^[SML]{1}[a-zA-Z0-9]{9}$")
    @Column(unique = true, nullable = false)
    private String prendaId;

    private Double precio;
    private Double precioPromocion;
    private Categoria categoria;

    // Constructores
    public Prendas() {    
    }

    public Prendas(String prendaId, Double precio, Double precioPromocion, Categoria categoria) {
        this.prendaId = prendaId;
        this.precio = precio;
        this.precioPromocion = precioPromocion;
        this.categoria = categoria;
    }  

    // Getters y Setters Atributos Prenda
    public String getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(String prendaId) {
        this.prendaId = prendaId;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioPromocion() {
        return precioPromocion;
    }

    public void setPrecioPromocion(Double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Prendas{" + "prendaId=" + prendaId + ", precio=" + precio
                + ", precioPromocion=" + precioPromocion
                + ", categoria=" + categoria + '}';
    }

}
