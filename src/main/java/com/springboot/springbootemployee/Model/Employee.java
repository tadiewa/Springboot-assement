package com.springboot.springbootemployee.Model;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
 import java.util.*;
@Data
@Entity
@Table(name="Employee")
public class Employee {
    // primary key
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id ;

      // @column used to provide column details
    @Column(name="firstname", nullable = false)
    private String firstName;
    @Column(name="lastname")
    private String lastName ;
    @Column(name="jobTitle")
    private String jobTitle;
    @Column(name="Dob")
    private String Dob;
    @Column(name="CreateStamp")
    private LocalDate CreateStamp;


}
