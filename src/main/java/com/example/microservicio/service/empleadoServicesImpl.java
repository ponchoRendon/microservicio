package com.example.microservicio.service;

import com.example.microservicio.entity.Empleado;
import com.example.microservicio.repository.EmpleadoLayImpl;
import com.example.microservicio.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empleadoServicesImpl")
public class empleadoServicesImpl implements empleadoServices {

    @Autowired
    EmpleadoLayImpl empleadoRepo;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepo.getallEmpleado();
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {

        return empleadoRepo.saveEmpleado(new Empleado(empleado.getNombre(),empleado.getNumEmpleado(),empleado.getSalario(),empleado.getEmpresa()));
    }
}
