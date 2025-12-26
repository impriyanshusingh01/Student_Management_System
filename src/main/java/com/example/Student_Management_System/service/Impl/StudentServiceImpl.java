package com.example.Student_Management_System.service.Impl;

import com.example.Student_Management_System.entity.StudentEntity;
import com.example.Student_Management_System.modal.StudentDto;
import com.example.Student_Management_System.repository.StudentRepository;
import com.example.Student_Management_System.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getStudent() {
        List<StudentEntity> studentData = studentRepository.findAll();
        List<StudentDto> studentList = new ArrayList<>();
        for (StudentEntity element : studentData) {
            studentList.add(new StudentDto(element.getId(),
                    element.getName(),
                    element.getEmail(),
                    element.getGrade(),
                    element.getMobile_number()));
        }
        return studentList;
    }

    @Override
    public StudentDto getStudentById(Long id) {

        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not match" + id));

        return new StudentDto(studentEntity.getId(),
                studentEntity.getName(),
                studentEntity.getEmail(),
                studentEntity.getGrade(),
                studentEntity.getMobile_number());
    }

    @Override
    public StudentDto createStudentData(StudentDto studentDto) {
        StudentEntity studentData = new StudentEntity();
        studentData.setName(studentDto.getName());
        studentData.setEmail(studentDto.getEmail());
        studentData.setGrade(studentDto.getGrade());
        studentData.setMobile_number(studentDto.getMobile_number());

        StudentEntity student = studentRepository.save(studentData);

        return new StudentDto(student.getId(),
                student.getName(),
                student.getEmail(),
                student.getGrade(),
                student.getMobile_number());

    }

    @Override
    public StudentDto updateStudentData(Long id, StudentDto studentDto) {

        StudentEntity studentData = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found" + id));
        studentData.setName(studentDto.getName());
        studentData.setEmail(studentDto.getEmail());
        studentData.setGrade(studentDto.getGrade());
        studentData.setMobile_number(studentDto.getMobile_number());

        StudentEntity student = studentRepository.save(studentData);
        return new StudentDto(student.getId(),
                student.getName(),
                student.getEmail(),
                student.getGrade(),
                student.getMobile_number());
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("id not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentPartial(Long id, Map<String, Object> updates) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id not found" + id));

        for (Map.Entry<String, Object> e : updates.entrySet()) {
            String key = e.getKey();
            Object value = e.getValue();

            switch (key) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                case "grade":
                    student.setGrade((String) value);
                    break;
                case "mobile_number":
                    student.setMobile_number((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not valid");
            }
        }

        StudentEntity update = studentRepository.save(student);

        return new StudentDto(update.getId(),
                update.getName(),
                update.getEmail(),
                update.getGrade(),
                update.getMobile_number());
    }

}

