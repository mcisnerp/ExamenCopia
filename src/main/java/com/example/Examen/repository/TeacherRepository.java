package com.example.Examen.repository;

import com.example.Examen.entity.Teacher;
import com.example.Examen.entity.TeacherTwo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TeacherRepository extends CrudRepository<Teacher,Integer> {

    List<Teacher> findTeacherByNombreAndEdad(String nombre, Integer edad);

    @Query(value = "Select * from maestros where nombre=:nombre and edad=:edad",nativeQuery = true)
    List<Teacher> findTeacherByNameAndAgePorQuerynNativa(String nombre, Integer edad);

    @Query(value = "Select * from maestros",nativeQuery = true)
    List<Teacher> findAllTeachers();

    @Modifying
    @Query(value = "UPDATE maestros SET apellido=:apellido, direccion=:direccion, edad=:edad, nombre=:nombre WHERE id=:id",nativeQuery = true)
    void updateTeacherById(String apellido, String direccion, Integer edad, String nombre, Integer id);

    @Query(value= "Select t from Teacher t where t.nombre=?1 and t.edad=?2")
    List<Teacher> findTeacherByNameAndAgePorJPQL(String nombre, Integer edad);


    @Query(value= "Select t.nombre,t.direccion from Teacher t where t.edad=?1")
    List<String> findTeacherByNameAndAgePorJPQL2(Integer edad);


    @Query(value= "Select new com.example.Examen.entity.TeacherTwo(t.nombre,t.direccion) from Teacher t where t.edad=?1")
    List<TeacherTwo> findTeacherByNameAndAgePorJPQL3(Integer edad);

    @Query(value= "Select t from Teacher t join t.cursoList c where c.nombre=:nombre")
    List<Teacher> findTeacherByCurso(String nombre);

}
