package com.example.m2_Testing_David_SansSinSpringWeb;

import com.example.m2_Testing_David_SansSinSpringWeb.entities.SmartPhone;
import com.example.m2_Testing_David_SansSinSpringWeb.repositories.SmartPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingDavidSansSinSpringWebApplication implements CommandLineRunner {

	@Autowired
	SmartPhonesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(M2TestingDavidSansSinSpringWebApplication.class, args);

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

	public void subMenu() {
		System.out.println("0- Volver atrás ");
		System.out.println("1- Ver Todos: ");
		System.out.println("2- Buscar por Id: ");
		System.out.println("3- Buscar por fabricante: ");
		System.out.println("4- Buscar por precio menor que: ");
		System.out.println("5- Buscar por Megapixels y por memoria Ram: ");
		System.out.println("6- Buscar por el Modelo: ");
		System.out.println("7- Buscar hasta un precio determinado: ");
		System.out.println("8- Consultar la cantidad de registros: ");
		System.out.println("9- Verificar si existe una Id: ");
	}

	@Override
	public void run(String... args)  {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			menuShow();
			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion == 0) {
					System.out.println("Hasta la próxima");
					break;
				} else if (opcion == 1) {
					System.out.println("Introduce el fabricante");
					String manufacturer = scanner.nextLine();
					System.out.println("Introduce el modelo");
					String model = scanner.nextLine();
					System.out.println("Introduce la cantidad de Megapixeles");
					Integer mPixel = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduce la cantidad de memoria RAM");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduce el precio");
					Double precio = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("¿El dispositivo dispone de Huella inteligente?");
					Boolean huella = scanner.nextBoolean();

					// 2. Crear el objeto
					SmartPhone telefono = new SmartPhone(null, manufacturer, model, precio, mPixel, huella, ram);

					// 3. Guardar el objeto  en base de datos
					repository.save(telefono);
					System.out.println("Smartphone creado correctamente");

				} else if (opcion == 2) {
					System.out.println("Por favor, introduzca el id del Smartphone que desea modificar");
					Long id = scanner.nextLong();
					scanner.nextLine();
					Optional<SmartPhone> smartPhonesOptional = repository.findById(id);
					if (smartPhonesOptional.isEmpty()) {
						System.out.println("No existe el Smartphone solicitado");
						continue;
					}
					SmartPhone smartp = smartPhonesOptional.get();
					System.out.println("Introduce el fabricante (Actual " + smartp.getManufacturer() + ") ");
					String manufacturer = scanner.nextLine();
					smartp.setManufacturer(manufacturer);
					System.out.println("Introduce el modelo(Actual " + smartp.getModel() + ") ");
					String model = scanner.nextLine();
					smartp.setModel(model);
					System.out.println("Introduce la cantidad de Megapixels (Actual " + smartp.getPixel() + ") ");
					Integer mPixel = scanner.nextInt();
					scanner.nextLine();
					smartp.setPixel(mPixel);
					System.out.println("Introduce la cantidad de memoria RAM (Actual " + smartp.getRam() + ") ");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					smartp.setRam(ram);
					System.out.println("Introduce el precio (Actual " + smartp.getPrice() + " ) ");
					Double precio = scanner.nextDouble();
					scanner.nextLine();
					smartp.setPrice(precio);
					System.out.println("¿El dispositivo dispone de Huella inteligente? (Actual " + smartp.getHuella() + ") ");
					Boolean huella = scanner.nextBoolean();
					smartp.setHuella(huella);
					repository.save(smartp);
					System.out.println(" Smartphone actualizado correctamente!");

				} else if (opcion == 3) {
					System.out.println("ha elegido la opción buscar: ");

					while (true) {
						subMenu();
						scanner = new Scanner(System.in);
						int subOpcion = scanner.nextInt();
						scanner.nextLine();

						if (subOpcion == 0) {
							System.out.println("volver al menu principal");
							break;
						} else if (subOpcion == 1) {
							System.out.println("Mostrar todos: ");
							List<SmartPhone> telefono = repository.findAll();
							if (telefono.isEmpty()) {
								System.out.println("No hay Smartphones disponibles.");
							} else {
								System.out.println(telefono);
							}


						} else if (subOpcion == 2) {
							System.out.println("Introduzca la Id a buscar: ");
							Long id = scanner.nextLong();
							scanner.nextLine();
							Optional<SmartPhone> smartPhonesOptional = repository.findById(id);
							if (smartPhonesOptional.isPresent()) {
								SmartPhone phones = smartPhonesOptional.get();
								System.out.println(phones);
							} else {
								System.out.println("No existe el smartphone seleccionado");
							}
						} else if (subOpcion == 3) {
							System.out.println("Introduce un fabricante a buscar: ");
							String manufacturer = scanner.nextLine();

							for (SmartPhone phone : repository.findByManufacturerIgnoreCase(manufacturer))
								System.out.println(phone);


						} else if (subOpcion == 4) {
							System.out.println("Introduzca el precio de filtrado: ");
							Double price = scanner.nextDouble();
							scanner.next();

							for (SmartPhone phone : repository.findByPriceLessThan(price))
								System.out.println(phone);

						} else if (subOpcion == 5) {
							System.out.println("Introduzca los megapixels a buscar: ");
							Integer pixel = scanner.nextInt();
							scanner.next();
							System.out.println("Introduzca la cantidad de memoria Ram a buscar: ");
							Integer ram = scanner.nextInt();
							scanner.next();

							for (SmartPhone phone : repository.findByPixelAndRam(pixel, ram))
								System.out.println(phone);

						} else if (subOpcion == 6) {
							System.out.println("Introduzca el modelo a buscar: ");
							String model = scanner.next();

							for (SmartPhone phone : repository.findByModelIgnoreCase(model))
								System.out.println(phone);

						} else if (subOpcion == 7) {
							System.out.println("Introduzca el precio hasta el que desea buscar: ");
							Double preciotope = scanner.nextDouble();
							List<SmartPhone> phones = repository.findByPriceLessThan(preciotope);
							for (SmartPhone smartPhone : phones) {
								System.out.println(smartPhone);
							}
						} else if (subOpcion == 8) {
							Long numero = repository.count();
							System.out.println("Ha escogido la opción consultar el numero de registros " + numero);
						}else if (subOpcion == 9){
							System.out.println("Introduzca la Id a comprobar: ");
							Long id = scanner.nextLong();
							scanner.nextLine();
							Optional<SmartPhone> smartPhonesOptional = repository.findById(id);
							if (smartPhonesOptional.isPresent()) {
								System.out.println("El equipo exite en la base de datos");		}
						 else {
							System.out.println("No hay Smartphones con esta Id.");}

					}else {
							System.out.println("Opción no disponible");
						}
					}
				} else if (opcion == 4) {
					System.out.println("Introduzca el id del Smartphone que desea borrar");
					Long id = scanner.nextLong();
					boolean exists = repository.existsById(id);

					if (exists) {
						repository.deleteById(id);
						System.out.println("Registro de Smartphone borrado");
					} else {
						System.out.println("No existe el SmartPhone solicitado");
					}


				} else if (opcion == 5) {
					System.out.println("Esto borrará todos los registros de los Smartphones, ¿está seguro? (true o false)");
					boolean confirm = scanner.nextBoolean();

					if (!confirm) continue;

					repository.deleteAll();
					System.out.println("Registros borrados correctamente");


								} else  {
					System.out.println("Opción no disponible");



					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

