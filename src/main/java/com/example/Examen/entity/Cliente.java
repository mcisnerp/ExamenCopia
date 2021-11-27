package com.example.Examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="Clientes")
@JsonIgnoreProperties(ignoreUnknown = true)

//@Getter @Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer dni;

    private String name;
    private String address;
   // private List<Prestamo> prestamos;

    /*public Prestamo addPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
        return prestamo;
    }
*/
    public Cliente(String name, Integer dni, String address) {
        this.name = name;
        this.dni = dni;
        this.address = address;
    }

    public Cliente(Integer dni) {
        this.dni = dni;
    }


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cliente() {
    }

    public Cliente(Integer dni, String name, String address) {
        this.dni = dni;
        this.name = name;
        this.address = address;
    }
}
