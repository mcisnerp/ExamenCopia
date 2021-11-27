package com.example.Examen.controller;

import com.example.Examen.entity.Cliente;
import com.example.Examen.entity.Teacher;
import com.example.Examen.entity.TeacherTwo;
import com.example.Examen.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ClientesContoller {
    @Autowired
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RepositoryCliente teacherRepository;

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        System.out.println("Se hizo la solicitud");
        repositoryCliente.addClienteRepository(cliente);
        return ResponseEntity.ok(cliente);
    }
/*
    @GetMapping
    public List<Cliente> getCLientes(){
        return clienteRepository.getClientes();
    }*/
//CRUD Teachers
    @PostMapping("/addTeacher") //C
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        teacherRepository.addTeacherRepository(teacher);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/teacherbyQuery/{nombre}/{edad}") //R
    public List<Teacher> getTeacherByNameAndAgePorQueryNativo(@PathVariable String nombre,@PathVariable Integer edad){
        return teacherRepository.getTeacherByNameAndAgeByQuery(nombre,edad);
    }

    @GetMapping("/teacherAll")
    public List<Teacher> getAllTeachers(){
        return teacherRepository.getAllTeachers();
    }

    @PutMapping("/updateTeacher") //U
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher){
        teacherRepository.updateTeacher(teacher);
        return ResponseEntity.ok("Actualizacion exitosa");
    }


    @DeleteMapping("/deleteTeacher") //D
    public ResponseEntity<Teacher> deleteTeacher(@RequestBody Teacher teacher){
        teacherRepository.deleteTeacher(teacher);
        return ResponseEntity.ok(teacher);
    }

    /*@GetMapping("/teacher/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameAndAge(@PathVariable("{nombre}") String nombre,@PathVariable("{edad}") Integer edad){
        return teacherRepository.getTeacherByNameAndAge(nombre,edad);
    }*/



    @GetMapping("/teacherbyJPQL/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameAndAgePorJPQL(@PathVariable String nombre, @PathVariable Integer edad){
        return teacherRepository.getTeacherByNameAndAgeByJPQL(nombre,edad);
    }

    @GetMapping("/teacherJPQL2/{edad}")
    public List<String> getTeacherByAgeJPQL(@PathVariable Integer edad){
        return teacherRepository.getTeacherByAgeJpql2(edad);
    }

    @GetMapping("/teacherJPQL3/{edad}")
    public List<TeacherTwo> getTeacherByAgeJPQL2(@PathVariable Integer edad){
        return teacherRepository.getTeacherByAgeJpql3(edad);
    }

    @GetMapping("/teacherbycurso/{curso}")
    public List<Teacher> getTeacherByCurso(@PathVariable String curso){
        return teacherRepository.getTeacherByCurso(curso);
    }




    /* //EXAMEN CRUD SIN SQL
    @Autowired

    private ClienteRepository clientes;


    @PostMapping//C
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        System.out.println("Solicitud de creacion de cliente");
        clientes.getClientes().add(new Cliente(cliente.getName(),cliente.getDni(),cliente.getAddress()));
        return  ResponseEntity.ok(cliente);

    }

    @GetMapping//R
    public List<Cliente> getCliente() {
        return clientes.getClientes();
    }

    @PutMapping//U
    public void modificarCliente(@RequestBody Cliente cliente) {
        borrarCliente(cliente.getName());
        clientes.getClientes().add(cliente);
    }


    @DeleteMapping//D
    public void eliminarCliente(@RequestBody Cliente cliente) {
        borrarCliente(cliente.getName());
    }

    public void borrarCliente(@PathVariable String nombre) {
        Optional<Cliente> optionalCliente = buscarCliente(nombre);
        if (optionalCliente.isPresent()) {
            clientes.getClientes().remove(optionalCliente.get());
        }
    }

    private Optional<Cliente> buscarCliente(String nombre) {
        return clientes.getClientes().stream().filter(c -> c.getName().equalsIgnoreCase(nombre)).findFirst();
    }

*/
}
