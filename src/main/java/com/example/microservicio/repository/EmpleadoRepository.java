package com.example.microservicio.repository;

import com.example.microservicio.entity.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmpleadoRepository extends MongoRepository<Empleado, Long> {

    @Override
    List<Empleado> findAll();

}
