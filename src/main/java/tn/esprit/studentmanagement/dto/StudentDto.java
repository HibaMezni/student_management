package tn.esprit.studentmanagement.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.studentmanagement.entities.Department;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Long idStudent;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
    private Department department;
}