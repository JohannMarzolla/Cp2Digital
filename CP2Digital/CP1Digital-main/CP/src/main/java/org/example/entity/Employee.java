package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String title;
    private Double salario;

    private String manager;
    @ManyToOne
    private Departament department;


    public Employee() {
    }

    public Employee(Long id, String name, String title, Double salario, String manager, Departament department) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.salario = salario;
        this.manager = manager;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Departament getDepartment() {
        return department;
    }

    public void setDepartment(Departament department) {
        this.department = department;
    }
}
