package com.lawfalfirstspring.lawfalspringfirst.controller;

import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @GetMapping("/get-all")
    public List<tbl_function> get(){
        return functionService.get();
    }

    @PostMapping("/save")
    public String saveFunction(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            HttpServletResponse httpResponse
    ) throws Exception{
        tbl_function newData = new tbl_function();
        newData.setId(id);
        newData.setName(name);
        newData.setDescription(desc);
        newData.setCreatedDate(new Date());
        functionService.save(newData);

        httpResponse.sendRedirect("/");
        return null;
    }

    @GetMapping("/get/{id}")
    public tbl_function getObj(@PathVariable int id){
        tbl_function obj = functionService.get(id);
        if(obj == null){
            throw new RuntimeException("function with id "+id+" is not found");
        }
        return obj;
    }

    @GetMapping("/delete/{id}")
    public String delObj(@PathVariable int id){
        functionService.delete(id);
        return "Delete success";
    }

    @PutMapping("/update")
    public tbl_function updateFunction(@RequestBody tbl_function data){
        functionService.save(data);
        return data;
    }
}
