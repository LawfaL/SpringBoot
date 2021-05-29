package com.lawfalfirstspring.lawfalspringfirst.controller;

import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.model.tbl_roles;
import com.lawfalfirstspring.lawfalspringfirst.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping("/get-all")
    public List<tbl_roles> get(){
        return rolesService.get();
    }

    @PostMapping("/save")
    public String saveFunction(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            HttpServletResponse httpResponse
    ) throws Exception{
        tbl_roles newData = new tbl_roles();
        newData.setId(id);
        newData.setName(name);
        newData.setDescription(desc);
        newData.setCreatedDate(new Date());
        rolesService.save(newData);

        httpResponse.sendRedirect("/");
        return null;
    }

    @PostMapping("/save/roles")
    public String roleSaves(
            @RequestParam("roles") String id_roles,
            @RequestParam("function") String id_functions,
            HttpServletResponse httpResponse
    ) throws Exception{
        rolesService.updateFunctions(id_roles, id_functions);
        httpResponse.sendRedirect("/");
        return null;
    }

    @GetMapping("/get/{id}")
    public tbl_roles getObj(@PathVariable int id){
        tbl_roles obj = rolesService.get(id);
        if(obj == null){
            throw new RuntimeException("function with id "+id+" is not found");
        }
        return obj;
    }

    @GetMapping("/delete/{id}")
    public String delObj(@PathVariable int id){
        rolesService.delete(id);
        return "Delete success";
    }

    @PutMapping("/update")
    public tbl_roles updateFunction(@RequestBody tbl_roles data){
        rolesService.save(data);
        return data;
    }
}
