package com.example.pcthanhcongserver.services.impl;

import com.example.pcthanhcongserver.contants.RoleEnum;
import com.example.pcthanhcongserver.entity.User;
import com.example.pcthanhcongserver.services.IUserAuthorizerService;
import com.example.pcthanhcongserver.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.Objects;

@Service("userAuthorizer")
public class UserAuthorizerService implements IUserAuthorizerService {
    @Autowired(required = false)
    private IUserService userService;

    @Override
    public boolean isAdmin(Authentication authentication){
        return Arrays.toString(authentication.getAuthorities().toArray()).contains(RoleEnum.ADMIN);
    }

    @Override
    public boolean isClient(Authentication authentication) {
        return Arrays.toString(authentication.getAuthorities().toArray()).contains(RoleEnum.CLIENT);
    }

    @Override
    public boolean isYourself(Authentication authentication, Integer userId) throws AccessDeniedException {
        User userAuth = (User) authentication.getPrincipal();
        com.example.pcthanhcongserver.entity.User user = userService.findByUsername(userAuth.getUsername());
        if (!Objects.equals(user.getId(),userId)){
            throw new AccessDeniedException("Access denied");
        }
        return true;
    }

}
