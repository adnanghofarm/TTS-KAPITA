/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.services;

import com.metrodata.Rest.entities.RegisterInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Boona
 */
@Service
public class RegisterRestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;

    public boolean register(RegisterInput input) {
        HttpEntity<RegisterInput> request = new HttpEntity<>(input, null);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(uri + "register",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Boolean>() {
        });
        return responseEntity.getBody();
    }
}
