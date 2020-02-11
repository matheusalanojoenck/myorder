package com.example.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TELEFONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    public Integer getId() {
        return id;
    }

    public Restaurante setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurante setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurante setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Restaurante setEmail(String email) {
        this.email = email;
        return this;
    }
}
