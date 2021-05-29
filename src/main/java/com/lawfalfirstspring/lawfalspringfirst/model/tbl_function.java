package com.lawfalfirstspring.lawfalspringfirst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@Entity(name = "tbl_function")
@Table(name = "tbl_function")
public class tbl_function implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "role_function",
            joinColumns = @JoinColumn(name = "function_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<tbl_roles> rolesList = new ArrayList<>();
}
