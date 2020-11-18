/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.entities;

import lombok.Data;

/**
 *
 * @author Boona
 */
@Data
public class LoginInput {
    private String email;
    private String password;
}
