package com.powersi.material.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String username;
    private String password;
    private String introduction;
    private String avatar;

    @Transient
    private Set<String> roles;

}
