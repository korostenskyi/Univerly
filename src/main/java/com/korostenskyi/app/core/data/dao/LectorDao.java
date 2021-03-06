package com.korostenskyi.app.core.data.dao;

import com.korostenskyi.app.config.FactoryUtil;
import com.korostenskyi.app.core.data.entity.Contract;
import com.korostenskyi.app.core.data.entity.Lector;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LectorDao implements BaseDao<Lector> {

    private Session session;

    public LectorDao() {
        session = FactoryUtil.getSessionFactory().openSession();
    }

    public LectorDao(Session session) {
        setSession(session);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Lector lector) {
        getSession().save(lector);
    }

    @Override
    public void update(Lector lector) {
        getSession().update(lector);
    }

    @Override
    public Optional<Lector> get(int id) {
        return Optional.ofNullable(getSession().get(Lector.class, id));
    }

    @Override
    public List<Lector> getAll() {
        return (List<Lector>) getSession().createQuery("from Lector").list();
    }

    @Override
    public void delete(Lector lector) {
        getSession().delete(lector);
    }

    @Override
    public void deleteAll() {
        List<Lector> departmentList = getAll();

        departmentList.forEach(this::delete);
    }

    public Lector getLectorById(long id) {
        Query<Lector> query = getSession().createNativeQuery("select * from Lector where id_lector = :lectorId", Lector.class);
        query.setParameter("lectorId", id);

        return query.getSingleResult();
    }

    public List<Lector> getLectorsByNameTemplate(String template) {
        Query<Lector> query = getSession().createNativeQuery("select * from Lector where lector_name like :nameTemplate", Lector.class);
        query.setParameter("nameTemplate", "%" + template + "%");

        return query.list();
    }
}
