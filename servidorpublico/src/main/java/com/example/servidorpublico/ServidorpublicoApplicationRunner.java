package com.example.servidorpublico;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.servidorpublico.model.ServidorPublico;
import com.example.servidorpublico.service.ServidorPublicoService;

import jakarta.annotation.PostConstruct;

@Configuration
public class ServidorpublicoApplicationRunner implements CommandLineRunner {

  @Autowired
  private ServidorPublicoService servidorPublicoService;

  @PostConstruct
  public void listAll() {

    List<ServidorPublico> servidoresPublicos = servidorPublicoService.listAll();

    if (servidoresPublicos.size() > 0) {
      servidoresPublicos.forEach(
          servidor -> {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(servidor.toString());
          });
    } else {
      System.out.println("Arquivo JSON vazio.");
    }

  }

  @PostConstruct
  public void listByMatricula() {

    long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula desejada: "));

    Optional<ServidorPublico> servidorPublico = servidorPublicoService.listByMatricula(matricula);

    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    if (servidorPublico.isPresent()) {
      System.out.println(servidorPublico.toString());
    } else {
      System.out.println("Não existe essa matrícula informada.");
    }

  }

  @Override
  public void run(String... args) throws Exception {
    // throw new UnsupportedOperationException("Unimplemented method 'run'");
  }

}
