package tn.esprit.studentmanagement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.dto.EnrollmentDto;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.services.IEnrollment;

import java.util.List;

@RestController
@RequestMapping("/Enrollment")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class EnrollmentController {

    private final IEnrollment enrollmentService;

    @GetMapping("/getAllEnrollment")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/getEnrollment/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping("/createEnrollment")
    public Enrollment createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        return enrollmentService.saveEnrollment(toEnrollment(enrollmentDto));
    }

    @PutMapping("/updateEnrollment")
    public Enrollment updateEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        return enrollmentService.saveEnrollment(toEnrollment(enrollmentDto));
    }

    @DeleteMapping("/deleteEnrollment/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }

    private Enrollment toEnrollment(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setIdEnrollment(enrollmentDto.getIdEnrollment());
        enrollment.setEnrollmentDate(enrollmentDto.getEnrollmentDate());
        enrollment.setGrade(enrollmentDto.getGrade());
        enrollment.setStatus(enrollmentDto.getStatus());
        enrollment.setStudent(enrollmentDto.getStudent());
        enrollment.setCourse(enrollmentDto.getCourse());
        return enrollment;
    }
}