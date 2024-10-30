package tech.ada.rflima.santander_coders.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.rflima.santander_coders.dto.response.EnderecoDTO;

@Service
public class BuscarEnderecoCEPService {

    private final RestTemplate restTemplate;

    @Value("${service.endereco.host}")
    private String urlViaCep;

    public BuscarEnderecoCEPService() {
        restTemplate = new RestTemplate();
    }

    public EnderecoDTO execute(String cep) {
        return restTemplate.getForObject(urlViaCep, EnderecoDTO.class, cep);
    }
}
