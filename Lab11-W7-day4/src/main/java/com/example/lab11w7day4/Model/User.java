package com.example.lab11w7day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "not valid user name")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;
    @NotEmpty(message = "not valid password")
    @Column(columnDefinition = "varchar(25) not null")
    private String password;
    @NotEmpty(message = "not valid email")
    @Email(message = "not valid email syntax ")
    @Column(columnDefinition = "varchar(25) not null")
    private String email;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDate registration_date = LocalDate.now();


    public User(){}
    public User(Integer id, String username, String password, String email, LocalDate registration_date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        //this.registration_date = registration_date;
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getUser_id() {
        return id;
    }

    public void setUser_id(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "not valid user name") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "not valid user name") String username) {
        this.username = username;
    }

    public @NotEmpty(message = "not valid password") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "not valid password") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "not valid email") @Email(message = "not valid email syntax ") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "not valid email") @Email(message = "not valid email syntax ") String email) {
        this.email = email;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }
}
