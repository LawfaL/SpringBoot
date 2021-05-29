package com.lawfalfirstspring.lawfalspringfirst.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity(name = "tbl_roles")
@Table(name = "tbl_roles")
public class tbl_roles implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonBackReference
    @ManyToMany(mappedBy = "rolesList")
    List<tbl_function> rolesFunctions = new ArrayList<>();

    public void addFunction(tbl_function function){
        if(!rolesFunctions.contains(function)){
            rolesFunctions.add(function);
            function.getRolesList().add(this);
        }
    }

}
