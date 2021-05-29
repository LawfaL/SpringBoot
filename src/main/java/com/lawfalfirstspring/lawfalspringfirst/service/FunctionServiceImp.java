package com.lawfalfirstspring.lawfalspringfirst.service;

import com.lawfalfirstspring.lawfalspringfirst.dao.FunctionDAO;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FunctionServiceImp implements FunctionService{

    @Autowired
    private FunctionDAO functionDAO;

    @Transactional
    @Override
    public List<tbl_function> get() {
        return functionDAO.get();
    }

    @Transactional
    @Override
    public tbl_function get(int id) {
        return functionDAO.get(id);
    }

    @Transactional
    @Override
    public void save(tbl_function data) {
        functionDAO.save(data);
    }

    @Transactional
    @Override
    public void delete(int id) {
        functionDAO.delete(id);
    }
}
