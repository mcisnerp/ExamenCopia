package com.example.Examen.repository;

import com.example.Examen.entity.Cliente;
import com.example.Examen.entity.Teacher;
import com.example.Examen.entity.TeacherTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@EnableJpaRepositories(basePackages = "com.example.Examen.repository")
public class RepositoryCliente {

    @Autowired
    RepositoryDAO clientedao;

    @Autowired
    TeacherRepository teacherRepository;

    public void addClienteRepository(Cliente cliente) {
            clientedao.save(cliente);
    }

    public List<Cliente> getClientes() {
       return (List<Cliente>) clientedao.findAll();
    }

    //public List<Teacher> getTeacherByNameAndAge(String nombre, Integer edad) {
       // return teacherRepository.findTeacherByNameAndAge(nombre,edad);
    //}

    public List<Teacher> getTeacherByNameAndAgeByQuery(String nombre, Integer edad) {
        return teacherRepository.findTeacherByNameAndAgePorQuerynNativa(nombre,edad);
    }

    public List<Teacher> getAllTeachers() {
        //return teacherRepository.findAllTeachers();
        return (List<Teacher>) teacherRepository.findAll();
        //teacherRepository.findById(id);
    }

    public void addTeacherRepository(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        String nombre= teacher.getNombre();
        String apellido= teacher.getApellido();
        String direccion=teacher.getDireccion();
        Integer edad= teacher.getEdad();
        Integer id= teacher.getId();
        teacherRepository.updateTeacherById(apellido,direccion,edad,nombre,id);
        return teacher;
        //return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }


    public List<Teacher> getTeacherByNameAndAgeByJPQL(String nombre, Integer edad) {
        return teacherRepository.findTeacherByNameAndAgePorJPQL(nombre,edad);
    }

    public List<String> getTeacherByAgeJpql2(Integer edad) {
        return teacherRepository.findTeacherByNameAndAgePorJPQL2(edad);
    }

    public List<TeacherTwo> getTeacherByAgeJpql3(Integer edad) {
        return teacherRepository.findTeacherByNameAndAgePorJPQL3(edad);
    }

    public List<Teacher> getTeacherByCurso(String curso) {
        return teacherRepository.findTeacherByCurso(curso);
    }
}
