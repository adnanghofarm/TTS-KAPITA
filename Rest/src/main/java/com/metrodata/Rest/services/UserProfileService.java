/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.services;

import com.metrodata.Rest.entities.UserAddress;
import com.metrodata.Rest.entities.UserContact;
import com.metrodata.Rest.entities.UserCurrentOccupation;
import com.metrodata.Rest.entities.UserEducation;
import com.metrodata.Rest.entities.UserInfo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Boona
 */
@Service
public class UserProfileService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;

    public UserInfo getUserInfo(String id) {
        UserInfo result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri + "profile/basic/{id}", UserInfo.class, param);
        return result;
    }

    public UserAddress getUserAddress(String id) {
        UserAddress result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri + "profile/address/{id}", UserAddress.class, param);
        return result;
    }
//
    public UserContact getUserContact(String id) {
        UserContact result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri + "profile/contact/{id}", UserContact.class, param);
        return result;
    }
//
    public UserCurrentOccupation getUserOccupation(String id) {
        UserCurrentOccupation result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri + "profile/currentoccupation/{id}", UserCurrentOccupation.class, param);
        return result;
    }
//
    public UserEducation getUserEducation(String id) {
        UserEducation result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri + "profile/education/{id}", UserEducation.class, param);
        return result;
    }
//
    public boolean saveBasicInformation(UserInfo userInfo) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "/profile/basic", userInfo, UserInfo.class);
            return result;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
//
    public boolean saveAddress(UserAddress userAddress) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/address", userAddress, UserAddress.class);
            return result;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
//    
    public boolean saveContact(UserContact userContact) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/contact", userContact, UserContact.class);
            return result;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
//    
    public boolean saveOccupationOccupation(UserCurrentOccupation userCurrentOccupation) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/currentoccupation", userCurrentOccupation, UserCurrentOccupation.class);
            return result;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    public boolean saveEducation(UserEducation userEducation) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/education", userEducation, UserEducation.class);
            return result;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
