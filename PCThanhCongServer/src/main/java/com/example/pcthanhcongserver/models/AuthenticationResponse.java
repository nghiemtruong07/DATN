package com.example.pcthanhcongserver.models;

import com.example.pcthanhcongserver.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationResponse {
    private String token;

    private User user;
}
