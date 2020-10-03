package com.example.microservicio.repository;


import com.example.microservicio.entity.Empleado;

import java.util.List;

public interface EmpleadoLay {

    Empleado saveEmpleado(Empleado empleado);
    List<Empleado> getallEmpleado();
}
