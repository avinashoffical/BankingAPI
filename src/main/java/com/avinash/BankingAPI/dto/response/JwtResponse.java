package com.avinash.BankingAPI.dto.response;

import java.util.List;

public class JwtResponse {
    private String token;

    private String type;

    private String username;

    private String email;

    private List<String> roles;
}
