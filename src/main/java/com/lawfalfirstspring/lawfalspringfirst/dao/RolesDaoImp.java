package com.lawfalfirstspring.lawfalspringfirst.dao;

import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_roles;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RolesDaoImp implements RolesDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<tbl_roles> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<tbl_roles> query = currentSession.createQuery("from tbl_roles", tbl_roles.class);
        List<tbl_roles> list = query.getResultList();
        return list;
    }

    @Override
    public tbl_roles get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        tbl_roles obj = currentSession.get(tbl_roles.class, id);
        return obj;
    }

    @Override
    public void save(tbl_roles data) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(data);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        tbl_roles obj = currentSession.get(tbl_roles.class, id);
        currentSession.delete(obj);
    }

    @Override
    public void updateFunction(String data, String functions) {
        Session currentSession = entityManager.unwrap(Session.class);
        tbl_roles obj = currentSession.get(tbl_roles.class, data);
        tbl_function function = currentSession.get(tbl_function.class, functions);

        obj.addFunction(function);
        currentSession.saveOrUpdate(obj);
    }
}
