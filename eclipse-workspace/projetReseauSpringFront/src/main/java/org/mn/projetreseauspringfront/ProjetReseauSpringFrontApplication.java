package org.mn.projetreseauspringfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProjetReseauSpringFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetReseauSpringFrontApplication.class, args);
	}

}
