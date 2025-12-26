package com.example.Student_Management_System.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_management_data")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String grade;
    private String mobile_number;

}

