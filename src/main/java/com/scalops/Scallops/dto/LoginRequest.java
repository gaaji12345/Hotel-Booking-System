package com.scalops.Scallops.dto;/*  gaajiCode
    99
    29/08/2024
    */

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email is need")
    private String email;
    @NotBlank(message = "Password is need..!")
    private String password;

}
