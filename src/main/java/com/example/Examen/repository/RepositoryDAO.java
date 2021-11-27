package com.example.Examen.repository;

import com.example.Examen.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryDAO extends CrudRepository<Cliente,Integer> {
}
