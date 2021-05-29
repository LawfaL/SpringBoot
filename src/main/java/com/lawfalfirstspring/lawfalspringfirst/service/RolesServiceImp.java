package com.lawfalfirstspring.lawfalspringfirst.service;

import com.lawfalfirstspring.lawfalspringfirst.dao.FunctionDAO;
import com.lawfalfirstspring.lawfalspringfirst.dao.RolesDAO;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolesServiceImp implements RolesService{

    @Autowired
    private RolesDAO rolesDAO;

    @Transactional
    @Override
    public List<tbl_roles> get() {
        return rolesDAO.get();
    }

    @Transactional
    @Override
    public tbl_roles get(int id) {
        return rolesDAO.get(id);
    }

    @Transactional
    @Override
    public void save(tbl_roles data) {
        rolesDAO.save(data);
    }

    @Transactional
    @Override
    public void delete(int id) {
        rolesDAO.delete(id);
    }

    @Transactional
    @Override
    public void updateFunctions(String data, String function) {
        rolesDAO.updateFunction(data, function);
    }
}
