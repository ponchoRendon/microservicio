package com.example.microservicio.controller;

import com.example.microservicio.entity.Empleado;
import com.example.microservicio.service.empleadoServicesImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/empleados")
public class empleadosController {

    @Autowired
    Gson gson;

    @Autowired
    @Qualifier("empleadoServicesImpl")
    empleadoServicesImpl empleadoServices;

    @GetMapping({"/listarTodos"})
    public ResponseEntity<?> listarEmpleados() throws Exception  {
        try{
            List<Empleado> empleadosList = empleadoServices.getEmpleados();
            String jsonRespDet = gson.toJson(empleadosList);

            return new ResponseEntity(jsonRespDet, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/guardarEmpleado")
    public ResponseEntity<?> guardarEmpleado(
            @RequestBody Empleado empleado
    ) throws Exception, URISyntaxException {
        try{
            Empleado objEmp = empleadoServices.saveEmpleado(empleado);
            String jsonRespDet = gson.toJson(objEmp);

            return new ResponseEntity(jsonRespDet, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empleado add(@RequestBody Empleado empleado) {
        return empleadoServices.saveEmpleado(empleado);
    }

}
