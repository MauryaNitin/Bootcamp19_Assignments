package com.ttn.springboot.controller;

import com.ttn.springboot.entity.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
    @Autowired
    Database database;

    @GetMapping("/database/details")
    public String getDatabaseConfig(){
        return database.getName() + database.getPort();
    }

    @GetMapping("/database/{name}/{port}")
    public void setDatabaseConfig(@PathVariable String name, @PathVariable int port){
        database.setName(name);
        database.setPort(port);
    }
}
