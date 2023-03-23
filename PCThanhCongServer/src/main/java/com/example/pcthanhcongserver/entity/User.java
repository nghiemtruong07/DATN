package com.example.pcthanhcongserver.entity;

import com.example.pcthanhcongserver.contants.StatusCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone", nullable = false,unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(name = "role")
    private String role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusCodeEnum status;

    @Column(name = "avatar",nullable = false,length = 500)
    private String avatar;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Cart cart;


}
