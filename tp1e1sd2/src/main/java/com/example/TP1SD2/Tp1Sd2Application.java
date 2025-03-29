package com.example.TP1SD2;

import com.example.TP1SD2.entities.Producto;
import com.example.TP1SD2.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Tp1Sd2Application implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1Sd2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Ingrese un código de barras (9 dígitos): ");
			int codigoBarras = scanner.nextInt();

			if (codigoBarras == 0) {
				System.out.println("exit");
				break;
			}

			Optional<Producto> producto = productoRepository.findByCodigoBarras(codigoBarras);

			producto.ifPresentOrElse(
					p -> {
						System.out.println("Producto encontrado: " + p.getNombre());
						System.out.println("Precio: $" + p.getPrecio());
					},
					() -> System.out.println("Producto no encontrado")
			);
		}
	}
}

