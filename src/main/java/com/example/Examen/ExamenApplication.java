package com.example.Examen;

import com.example.Examen.entity.Curso;
import com.example.Examen.entity.Teacher;
import com.example.Examen.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TeacherRepository teacherRepository) {
        return args -> {
			Curso cursoA = new Curso("a");
			Curso cursoB = new Curso("b");
			Curso cursoC = new Curso("c");


			Teacher teacher = new Teacher("Miguel","Cisneros","Juarez 3",25,List.of(cursoA,cursoB,cursoC));
       		teacherRepository.save(teacher);
        };
    }

}
