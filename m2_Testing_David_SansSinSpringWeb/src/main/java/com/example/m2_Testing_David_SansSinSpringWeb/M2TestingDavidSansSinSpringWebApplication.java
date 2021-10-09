package com.example.m2_Testing_David_SansSinSpringWeb;

import com.example.m2_Testing_David_SansSinSpringWeb.repositories.SmartPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M2TestingDavidSansSinSpringWebApplication implements CommandLineRunner {

	@Autowired
	SmartPhonesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(M2TestingDavidSansSinSpringWebApplication.class, args);
		System.out.println("Hola mundo");
	}
	public void menuShow() {
		System.out.println("Bienvenidos a la APP: ");
		System.out.println("0- Salir: ");
		System.out.println("1- Crear: ");
		System.out.println("2- Modificar por Id: ");
		System.out.println("3- Buscar: ");
		System.out.println("4- Borrar por Id: ");
		System.out.println("5- Borrar todos los registros: ");
	}

	public void submenu() {
		System.out.println("6- Ver Todos: ");
		System.out.println("7- Buscar por Id: ");
		System.out.println("8- Buscar por fabricante: ");
		System.out.println("9- Buscar por precio menor que: ");
		System.out.println("10- Buscar por Megapixels y por memoria Ram: ");
		System.out.println("11- Buscar por el Modelo: ");
		System.out.println("12- Buscar hasta un precio determinado: ");
	}

	@Override
	public void run(String... args)  {
		System.out.println("hasta aqui");
	}
}
