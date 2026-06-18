package tn.esprit.studentmanagement.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.services.IEnrollment;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Enrollment")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class EnrollmentController {

    private final IEnrollment enrollmentService;
    private final ObjectMapper objectMapper;

    @GetMapping("/getAllEnrollment")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/getEnrollment/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping("/createEnrollment")
    public Enrollment createEnrollment(@RequestBody Map<String, Object> enrollmentRequest) {
        Enrollment enrollment = objectMapper.convertValue(enrollmentRequest, Enrollment.class);
        return enrollmentService.saveEnrollment(enrollment);
    }

    @PutMapping("/updateEnrollment")
    public Enrollment updateEnrollment(@RequestBody Map<String, Object> enrollmentRequest) {
        Enrollment enrollment = objectMapper.convertValue(enrollmentRequest, Enrollment.class);
        return enrollmentService.saveEnrollment(enrollment);
    }

    @DeleteMapping("/deleteEnrollment/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}