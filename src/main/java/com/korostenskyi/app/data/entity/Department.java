package com.korostenskyi.app.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    private Long id;
    private String name;
    private String head;

    public Department() {

    }

    public Department(Long id, String name, String head) {
        this.id = id;
        this.name = name;
        this.head = head;
    }

    @Id
    @Column(name = "id_department")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "department_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "head_of_department")
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
