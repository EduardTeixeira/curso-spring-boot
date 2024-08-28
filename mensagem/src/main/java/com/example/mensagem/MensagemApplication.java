package com.example.mensagem;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class MensagemApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(MensagemApplication.class, args);
		System.out.println("Primeira mensagem.");
		// JOptionPane.showMessageDialog(null, "Primeiro Dialog.");
		// create();
		// read();
		// update();
		// delete();
	}

	@GetMapping("/")
	public String init() {
		return ("<a href=\"create\">Create</a>");
	}

	// @PostConstruct
	@GetMapping("/create")
	public String create() {
		System.out.println("Criação de um registro");
		return null;
	}

	// @PostConstruct
	public String read() {
		System.out.println("Leitura de um registro");
		return null;
	}

	// @PostConstruct
	public String update() {
		System.out.println("Atualização de um registro");
		return null;
	}

	// @PostConstruct
	public String delete() {
		System.out.println("Exclusão de um registro");
		return null;
	}

}
