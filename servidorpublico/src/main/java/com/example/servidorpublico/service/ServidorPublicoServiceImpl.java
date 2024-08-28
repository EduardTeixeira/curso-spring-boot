package com.example.servidorpublico.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.servidorpublico.model.ServidorPublico;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService {

  private final String SERVIDOR = "/data/servidorpublico.json";

  @Override
  public List<ServidorPublico> listAll() {

    try {

      TypeReference<List<ServidorPublico>> typeRef = new TypeReference<List<ServidorPublico>>() {
      };

      InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

      List<ServidorPublico> servidoresPublicos = new ObjectMapper().readValue(inputStream, typeRef);

      return servidoresPublicos;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }

  }

  @Override
  public Optional<ServidorPublico> listByMatricula(long matricula) {

    try {

      TypeReference<List<ServidorPublico>> typeRef = new TypeReference<List<ServidorPublico>>() {
      };

      InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

      List<ServidorPublico> servidoresPublicos = new ObjectMapper().readValue(inputStream, typeRef);

      Optional<ServidorPublico> servidorEncontrado = servidoresPublicos.stream().filter(
          servidor -> servidor.matricula().equals(matricula)).findFirst();

      return servidorEncontrado;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }

  }

}
