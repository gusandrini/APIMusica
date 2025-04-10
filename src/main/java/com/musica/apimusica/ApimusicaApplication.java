package com.musica.apimusica;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de Música - 2TDSPW CP2",
				description = "Uma API para gerenciar álbuns, músicas e artistas",
				version = "v1"
		)
)
public class ApimusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimusicaApplication.class, args);
	}

}
