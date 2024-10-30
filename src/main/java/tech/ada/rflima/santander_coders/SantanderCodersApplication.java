package tech.ada.rflima.santander_coders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ada.rflima.santander_coders.dto.response.EnderecoDTO;
import tech.ada.rflima.santander_coders.service.BuscarEnderecoCEPService;

@SpringBootApplication
public class SantanderCodersApplication implements CommandLineRunner {

	@Autowired
	BuscarEnderecoCEPService buscarEnderecoCEPService;

	public static void main(String[] args) {
		SpringApplication.run(SantanderCodersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EnderecoDTO execute = buscarEnderecoCEPService.execute("01001000");
		System.out.println(execute);
	}
}