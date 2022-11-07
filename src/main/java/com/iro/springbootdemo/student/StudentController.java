package com.iro.springbootdemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudent() {
        List<Student> returnList = new ArrayList<>();
        returnList.add(new Student(1L, "Iroshan", "iroshan@gmail.com", LocalDate.of(1984, Month.OCTOBER, 30), 38));
        return returnList;
    }
}
