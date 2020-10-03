package com.example.microservicio.repository;

import com.example.microservicio.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoLayImpl implements EmpleadoLay {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EmpleadoLayImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return mongoTemplate.save(empleado,"empleados");
    }

    @Override
    public List<Empleado> getallEmpleado() {
        return mongoTemplate.findAll(Empleado.class);
    }
}
