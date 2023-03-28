package com.example.pcthanhcongserver.services;

import com.example.pcthanhcongserver.dto.SignUpDTO;
import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.dto.update.UpdateUserDTO;
import com.example.pcthanhcongserver.entity.User;
import com.example.pcthanhcongserver.specifications.GenericSpecification;

public interface IUserService {
    PaginateDTO<User> getList(Integer page, Integer perPage, GenericSpecification<User> specification);
    User findByEmail(String email);

    User findByUsername(String username);

    User create(SignUpDTO signUpDTO);

    void activeUser(String token);

    User updateUser(User user);

    void create(User user);

    User findById(Integer userId);

    User update(UpdateUserDTO updateUserDTO, User currentUser);

    void deleteById(Integer userId);

}
