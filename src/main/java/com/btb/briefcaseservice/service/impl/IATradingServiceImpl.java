package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.service.IATradingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
@Service
public class IATradingServiceImpl implements IATradingService {

    private static final String AZURE_FUNCTION_URL = "?";

    private static final String AZURE_TOKEN = "?";

    @Override
    public Assets getIAFeedback() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("AZ-TOKEN", AZURE_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(entity, Assets.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);
        ResponseEntity<String> response;

        try {
            response = restTemplate.execute(new URI(AZURE_FUNCTION_URL), HttpMethod.POST, requestCallback, responseExtractor);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return convertJsonToObject(response.getBody(), Assets.class);
    }

    @Override
    public void copilotTrading() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("AZ-TOKEN", AZURE_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(entity, Assets.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);

        try {
            restTemplate.execute(new URI(AZURE_FUNCTION_URL), HttpMethod.POST, requestCallback, responseExtractor);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T> T convertJsonToObject(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir el JSON a objeto", e);
        }
    }

}
