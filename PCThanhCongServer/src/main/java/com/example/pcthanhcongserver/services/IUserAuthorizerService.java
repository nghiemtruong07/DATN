package com.example.pcthanhcongserver.services;

import org.springframework.security.core.Authentication;

import java.nio.file.AccessDeniedException;

public interface IUserAuthorizerService {
    boolean isAdmin(Authentication authentication);

    boolean isClient(Authentication authentication);

    boolean isYourself(Authentication authentication, Integer userId) throws AccessDeniedException;
}
