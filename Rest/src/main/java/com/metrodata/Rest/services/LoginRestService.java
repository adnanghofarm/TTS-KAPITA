/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.services;

import com.metrodata.Rest.entities.LoginInput;
import com.metrodata.Rest.entities.LoginOutput;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginRestService {
    
    @Autowired
    RestTemplate restTemplate;
    
    public LoginOutput login(LoginInput input){
        HttpEntity<LoginInput> request = new HttpEntity<>(input, null);
        ResponseEntity<LoginOutput> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<LoginOutput>(){
                }
        );
        return responseEntity.getBody();
    }
    
//    public void save(LoginInput input){
//        restTemplate.postForObject(uri)
//    }
    public String getById(LoginOutput output){
        return output.getUser().getId();
    }
            
}
