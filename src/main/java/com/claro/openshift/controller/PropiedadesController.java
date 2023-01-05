package com.claro.openshift.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claro.openshift.model.PropiedadesDTO;
import com.claro.openshift.service.IPropiedadService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "")
@CrossOrigin
public class PropiedadesController {
    @Autowired
	private IPropiedadService service;  

    @PostMapping(path = "/propiedades/admParametroEAF")
    public ResponseEntity<List<PropiedadesDTO>>consultarPropiedades(@RequestBody(required = true)PropiedadesDTO parametro){


        // return new ResponseEntity<List<PropiedadesDTO>>(new ArrayList<>(),HttpStatus.OK);
        return new ResponseEntity<List<PropiedadesDTO>>(service.consultarPropiedades(parametro),HttpStatus.OK);
    }


}