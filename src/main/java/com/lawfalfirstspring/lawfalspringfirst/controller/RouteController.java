package com.lawfalfirstspring.lawfalspringfirst.controller;

import com.lawfalfirstspring.lawfalspringfirst.model.tbl_function;
import com.lawfalfirstspring.lawfalspringfirst.service.FunctionService;
import com.lawfalfirstspring.lawfalspringfirst.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RouteController {

    @Autowired
    private FunctionService functionService;

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/")
    public String home(ModelMap model){
        model.addAttribute("function", functionService.get());
        model.addAttribute("roles", rolesService.get());
        return "Function";
    }
}
