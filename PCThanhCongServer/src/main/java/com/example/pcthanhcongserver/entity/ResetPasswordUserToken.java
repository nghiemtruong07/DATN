package com.example.pcthanhcongserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ResetPasswordUserToken")
public class ResetPasswordUserToken implements Serializable {
    @Id


}
