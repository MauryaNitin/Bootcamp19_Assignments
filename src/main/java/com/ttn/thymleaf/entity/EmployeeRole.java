package com.ttn.thymleaf.entity;

import java.util.List;
import java.util.Arrays;
// Ques 9: Create an ENUM with values USER, ADMIN, SUPER_ADMIN and iterate it to show a custom message to users basis on the ENUM value


public enum EmployeeRole{
    USER("User: Read, Write"), ADMIN("Admin: Create, Read, Write"), SUPER_ADMIN("Super Admin: Create, Read, Write, Delete");

    String message;

    EmployeeRole(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public static List<EmployeeRole> getRoles(){
        return Arrays.asList(USER, ADMIN, SUPER_ADMIN);
    }
}
