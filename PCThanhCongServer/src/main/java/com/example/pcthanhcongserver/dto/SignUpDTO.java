package com.example.pcthanhcongserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    @NotBlank
    private String usename;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String fullname;

    @NotBlank
    private String password;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    @NotBlank
    private String avatar;
}
