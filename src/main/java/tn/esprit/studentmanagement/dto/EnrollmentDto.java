package tn.esprit.studentmanagement.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.studentmanagement.entities.Course;
import tn.esprit.studentmanagement.entities.EnrollmentStatus;
import tn.esprit.studentmanagement.entities.Student;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentDto {
    private Long idEnrollment;
    private LocalDate enrollmentDate;
    private Double grade;
    private EnrollmentStatus status;
    private Student student;
    private Course course;
}