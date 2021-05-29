package com.lawfalfirstspring.lawfalspringfirst.service;

import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_roles;

import java.util.List;

public interface RolesService {
    // === GET ALL DATA ===
    List<tbl_roles> get();

    // === GET DATA BY ID ===
    tbl_roles get(int id);

    // === SAVE DATA ===
    void save(tbl_roles data);

    // === DELETE DATA ===
    void delete(int id);

    // === INSERT FUNCTION DATA ===
    void updateFunctions(String data, String functions);
}
