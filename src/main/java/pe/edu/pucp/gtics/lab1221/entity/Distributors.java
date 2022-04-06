package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.*;

@Entity
@Table(name = "distribuidoras")
public class Distributors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fundacion", nullable = false)
    private Integer fundacion;

    @Column(name = "sede", length = 45)
    private String sede;

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Integer getFundacion() {
        return fundacion;
    }

    public void setFundacion(Integer fundacion) {
        this.fundacion = fundacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
