package com.iro.springbootdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
//        List<Student> returnList = new ArrayList<>();
//        returnList.add(new Student(1L, "Iroshan", "iroshan@gmail.com", LocalDate.of(1984, Month.OCTOBER, 30), 38));
//        return returnList;
    }
}
