package com.example.Examen.entity;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Maestros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Integer edad;



    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name="cursosList")
    private List<Curso> cursoList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursos) {
        this.cursoList = cursos;
    }

    public Teacher() {
    }

    public Teacher(Integer id, String nombre, String apellido, String direccion, Integer edad, List<Curso> cursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.cursoList = cursos;
    }


    public Teacher(String nombre, String apellido, String direccion, Integer edad, List<Curso> cursoList) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.cursoList = cursoList;
    }
}
