package com.example.lab11w7day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "not valid name")
    @Column(columnDefinition = "varchar(17) not null")
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(String name) {
        this.name = name;
    }
    public Category() {}

    public Integer getCategory_id() {
        return id;
    }

    public void setCategory_id(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "not valid name") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "not valid name") String name) {
        this.name = name;
    }
}
