package com.korostenskyi.app.core.data.dao;

import com.korostenskyi.app.config.FactoryUtil;
import com.korostenskyi.app.core.data.entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DepartmentDao implements BaseDao<Department> {

    private Session session;

    public DepartmentDao() {
        session = FactoryUtil.getSessionFactory().openSession();
    }

    public DepartmentDao(Session session) {
        setSession(session);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Department department) {
        getSession().save(department);
    }

    @Override
    public void update(Department department) {
        getSession().update(department);
    }

    @Override
    public Optional<Department> get(int id) {
        return Optional.ofNullable(getSession().get(Department.class, id));
    }

    @Override
    public List<Department> getAll() {
        return (List<Department>) getSession().createQuery("from Department").list();
    }

    @Override
    public void delete(Department department) {
        getSession().delete(department);
    }

    @Override
    public void deleteAll() {
        List<Department> departmentList = getAll();

        departmentList.forEach(this::delete);
    }

    public Department getDepartmentByName(String name) {
        Query<Department> query = getSession().createNativeQuery("select * from Department where department_name = :departmentName", Department.class);
        query.setParameter("departmentName", name);

        List<Department> departmentList = query.list();

        return departmentList.get(0);
    }
}
