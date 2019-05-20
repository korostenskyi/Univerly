package com.korostenskyi.app.core.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

    private Long id;
    private Long departmentId;
    private Long lectorId;
    private Integer salary;

    public Contract() {

    }

    public Contract(Long id, Long departmentId, Long lectorId, Integer salary) {
        this.id = id;
        this.departmentId = departmentId;
        this.lectorId = lectorId;
        this.salary = salary;
    }

    @Id
    @Column(name = "id_contract")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "id_department")
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "id_lector")
    public Long getLectorId() {
        return lectorId;
    }

    public void setLectorId(Long lectorId) {
        this.lectorId = lectorId;
    }

    @Column(name = "lector_salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
