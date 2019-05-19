package com.korostenskyi.app.core.data.dao;

import com.korostenskyi.app.config.FactoryUtil;
import com.korostenskyi.app.core.data.entity.Contract;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ContractDao implements BaseDao<Contract> {

    private Session session;

    public ContractDao() {
        session = FactoryUtil.getSessionFactory().openSession();
    }

    public ContractDao(Session session) {
        setSession(session);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Contract contract) {
        getSession().save(contract);
    }

    @Override
    public void update(Contract contract) {
        getSession().update(contract);
    }

    @Override
    public Optional<Contract> get(int id) {
        return Optional.ofNullable(getSession().get(Contract.class, id));
    }

    @Override
    public List<Contract> getAll() {
        return (List<Contract>) getSession().createQuery("from Contract").list();
    }

    @Override
    public void delete(Contract contract) {
        getSession().delete(contract);
    }

    @Override
    public void deleteAll() {
        List<Contract> departmentList = getAll();

        departmentList.forEach(this::delete);
    }
}
