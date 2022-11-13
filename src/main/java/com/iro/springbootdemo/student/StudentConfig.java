package com.iro.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            List<Student> returnList = new ArrayList<>();
            returnList.add(new Student("Iroshan", "iroshan@gmail.com", LocalDate.of(1984, Month.OCTOBER, 30)));
            returnList.add(new Student("Parasanna", "iroshan2@gmail.com", LocalDate.of(1986, Month.OCTOBER, 30)));
            studentRepository.saveAll(returnList);
        };
    }
}
