package com.example.servidorpublico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.example.servidorpublico.model.ServidorPublico;
import com.example.servidorpublico.service.ServidorPublicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ServidorPublicoController {

  @Autowired
  private ServidorPublicoService servidorPublicoService;

  @GetMapping("/listAll")
  public List<ServidorPublico> listAll() {
    return servidorPublicoService.listAll();
  }

  @GetMapping("/list/{matricula}")
  public Optional<ServidorPublico> listByMatricula(@PathVariable Long matricula) {
    return servidorPublicoService.listByMatricula(matricula);
  }

}
