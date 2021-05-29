package com.lawfalfirstspring.lawfalspringfirst.dao;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FunctionDaoImp implements FunctionDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<tbl_function> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<tbl_function> query = currentSession.createQuery("from tbl_function", tbl_function.class);
        List<tbl_function> list = query.getResultList();
        return list;
    }

    @Override
    public tbl_function get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        tbl_function obj = currentSession.get(tbl_function.class, id);
        return obj;
    }

    @Override
    public void save(tbl_function data) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(data);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        tbl_function obj = currentSession.get(tbl_function.class, id);
        currentSession.delete(obj);
    }
}
