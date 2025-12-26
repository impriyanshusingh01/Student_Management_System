package com.example.Student_Management_System;


import com.example.Student_Management_System.modal.StudentDto;
import com.example.Student_Management_System.repository.StudentRepository;
import com.example.Student_Management_System.service.StudentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class StudentTest {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void studentListTest() {
        List<StudentDto> student = studentService.getStudent();
        System.out.println(student);
        Assertions.assertNotNull(student);
    }

    @Test
    public void StudentCheckByIdTest() {

        StudentDto student = new StudentDto();
        student.setName("Priyanshu Rajpoot");
        student.setEmail("prya@example.com");
        student.setGrade("A+");
        student.setMobile_number("1234567890");

        StudentDto createDto = studentService.createStudentData(student);
        System.out.println(createDto);

        StudentDto getStudentById = studentService.getStudentById(createDto.getId());
        System.out.println(getStudentById);

        Assertions.assertEquals("Priyanshu Rajpoot", getStudentById.getName());
        Assertions.assertEquals("prya@example.com", getStudentById.getEmail());
        Assertions.assertEquals("A+", getStudentById.getGrade());
        Assertions.assertEquals("1234567890", getStudentById.getMobile_number());
        Long invalidId = 999L;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            studentService.getStudentById(invalidId);
        });

    }


    @Test
    public void createStudentTest() {
        StudentDto student = new StudentDto();
        student.setName("Priyanshu Rajpoot");
        student.setEmail("prya@example.com");
        student.setGrade("A+");
        student.setMobile_number("1234567890");

        StudentDto createDto = studentService.createStudentData(student);
        System.out.println(createDto);
        Assertions.assertNotNull(createDto.getId());
        Assertions.assertEquals("Priyanshu Rajpoot", createDto.getName());
        Assertions.assertEquals("prya@example.com", createDto.getEmail());
        Assertions.assertEquals("A+", createDto.getGrade());
        Assertions.assertEquals("1234567890", createDto.getMobile_number());
    }

    @Test
    public void updateStudent() {
        StudentDto student = new StudentDto();
        student.setName("Priyanshu Rajpoot");
        student.setEmail("prya@example.com");
        student.setGrade("A+");
        student.setMobile_number("1234567890");

        StudentDto createDto = studentService.createStudentData(student);
        System.out.println(createDto);


        StudentDto studentUpdate = new StudentDto();
        studentUpdate.setName("Priyanshu");
        studentUpdate.setEmail("priyanhu@exmaple.com");
        studentUpdate.setGrade("B+");
        studentUpdate.setMobile_number("123456764");

        StudentDto updateDto = studentService.updateStudentData(createDto.getId(), studentUpdate);

        System.out.println("After update" + updateDto);
        Assertions.assertEquals("Priyanshu", updateDto.getName());
        Assertions.assertEquals("priyanhu@exmaple.com", updateDto.getEmail());
        Assertions.assertEquals("B+", updateDto.getGrade());
        Assertions.assertEquals("123456764", updateDto.getMobile_number());
    }

    @Test
    public void deleteStudentTest() {
        StudentDto student = new StudentDto();
        student.setName("Priyanshu Rajpoot");
        student.setEmail("prya@example.com");
        student.setGrade("A+");
        student.setMobile_number("1234567890");

        StudentDto createDto = studentService.createStudentData(student);
        System.out.println(createDto);

        studentService.deleteStudent(createDto.getId());
        Long invalidId = 999L;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            studentService.getStudentById(invalidId);
        });

    }

    @Test
    public void updatePartialStudent() {
        StudentDto student = new StudentDto();
        student.setName("Priyanshu Rajpoot");
        student.setEmail("prya@example.com");
        student.setGrade("A+");
        student.setMobile_number("1234567890");

        StudentDto createDto = studentService.createStudentData(student);
        System.out.println(createDto);

        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "priyanshu");
        updates.put("grade", "B+");

        StudentDto studentPartialUpdate  = studentService.updateStudentPartial(createDto.getId(), updates);

        System.out.println(studentPartialUpdate);
        Assertions.assertEquals("priyanshu", studentPartialUpdate.getName());
        Assertions.assertEquals("B+", studentPartialUpdate.getGrade());
        Long invalidId = 999L;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            studentService.getStudentById(invalidId);
        });

    }
}
