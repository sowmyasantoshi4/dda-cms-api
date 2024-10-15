package com.cms.dda.security;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String username;
    private String token;
    private boolean isValid;
    private Integer status;
    private String message;
    private long requestTime;
    private long expiryTime;

    
    
}
