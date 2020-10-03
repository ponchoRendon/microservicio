package com.example.microservicio.service;

import com.example.microservicio.entity.Empleado;

import java.util.List;

public interface empleadoServices {

    List<Empleado> getEmpleados();

    Empleado saveEmpleado(Empleado empleado);
}
