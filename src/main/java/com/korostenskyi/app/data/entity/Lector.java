package com.korostenskyi.app.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "lector")
public class Lector {

    private Long id;
    private String name;
    private Degree degree;

    public Lector() {

    }

    public Lector(Long id, String name, Degree degree) {
        this.id = id;
        this.name = name;
        this.degree = degree;
    }

    @Id
    @Column(name = "id_lector")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "lector_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "degree")
    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
