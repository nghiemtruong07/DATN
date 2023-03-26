package com.example.pcthanhcongserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    @Size(max = 8)
    private String password;
    private String address;
    private String phoneNumber;
    private  String fullname;
    private  String avatar;
}
