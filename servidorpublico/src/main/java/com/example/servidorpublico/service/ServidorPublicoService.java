package com.example.servidorpublico.service;

import java.util.List;
import java.util.Optional;

import com.example.servidorpublico.model.ServidorPublico;

public interface ServidorPublicoService {

  List<ServidorPublico> listAll();

  Optional<ServidorPublico> listByMatricula(long id);

}
