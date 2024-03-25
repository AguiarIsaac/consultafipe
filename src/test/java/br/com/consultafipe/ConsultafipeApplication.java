package br.com.consultafipe;

import br.com.consultafipe.principal.Principal;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

@SpringBootApplication
public class ConsultafipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultafipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.iniciar();
	}
}
