/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.entities;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Boona
 */
@Data
public class UserOutput {
    private String id,email,password;
    private List<String> roles;
}
