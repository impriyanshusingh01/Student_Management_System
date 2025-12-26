package com.example.Student_Management_System.modal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;
import org.aspectj.bridge.MessageUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;

    @NotNull
    @Column(length = 50)
    private String name;

    @Email(message = "unique email required")
    @Column(unique = true)
    private String email;

    private String grade;

    @NotNull(message = "At least 10 digit required")
    @Column(length = 10)
    private String mobile_number;
}
