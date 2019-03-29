package com.ttn.restwithspring.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Ques 7: Create 2 versions of your API one take reprsent name of the Student as single string and other showing
// firstname and lastname seperately. (Create the Versions of the API using URI, parameter and header versioning)

@RestController
public class StudentVersionController {

    @GetMapping("/student/V1")
    StudentV1 getStudentV1() {
        return new StudentV1("Peter Choudhary");
    }

    @GetMapping("/student/V2")
    StudentV2 getStudentV2() {
        return new StudentV2(new Name("Peter","Choudhary"));
    }

    //Parameter Versioning
    // /person/param?version=1
    @GetMapping(value = "/student/param",params = "version=1")
    StudentV1 getStudentParam1() {
        return new StudentV1("Peter Choudhary");
    }

    @GetMapping(value = "/student/param",params = "version=2")
    StudentV2 getStudentParam2() {
        return new StudentV2(new Name("Peter","Choudhary"));
    }


    //Header Versioning
    //API-VERSION 1 header required with request
    @GetMapping(value = "/student/header",headers = "API-VERSION=1")
    StudentV1 getStudentHeader1() {
        return new StudentV1("Peter Choudhary");
    }

    @GetMapping(value = "/student/header",headers = "API-VERSION=2")
    StudentV2 getStudentHeader2() {
        return new StudentV2(new Name("Peter","Choudhary"));
    }
}
