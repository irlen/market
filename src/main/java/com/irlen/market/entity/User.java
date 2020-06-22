package com.irlen.market.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    private Integer roleId;
}
