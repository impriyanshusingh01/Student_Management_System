package com.example.Student_Management_System.service;

import com.example.Student_Management_System.modal.StudentDto;

import java.util.List;
import java.util.Map;


public interface StudentService {
    List<StudentDto> getStudent();

    StudentDto getStudentById(Long id);

    StudentDto createStudentData(StudentDto studentDto);

    StudentDto updateStudentData(Long id , StudentDto studentDto);

    void deleteStudent(Long id);

    StudentDto updateStudentPartial(Long id, Map<String, Object> updates);
}
