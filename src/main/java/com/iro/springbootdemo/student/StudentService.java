package com.iro.springbootdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        System.out.println(studentByEmail);
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email has taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with ID "+studentId+" does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with ID " + studentId + " does not exists"));

        if(studentName != null && studentName.length() >0 && !Objects.equals(student.getName(), studentName)){
            student.setName(studentName);
        }

        if(studentEmail != null && studentEmail.length() >0 && !Objects.equals(student.getEmail(), studentEmail)){
            student.setEmail(studentEmail);
        }
    }
}
