package com.lawfalfirstspring.lawfalspringfirst.dao;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;

import java.util.List;

public interface FunctionDAO {
// === GET ALL DATA ===
    List<tbl_function> get();

// === GET DATA BY ID ===
    tbl_function get(int id);

// === SAVE DATA ===
    void save(tbl_function data);

// === DELETE DATA ===
    void delete(int id);
}
