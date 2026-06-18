package tn.esprit.studentmanagement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.dto.StudentDto;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setIdStudent(studentDto.getIdStudent());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAddress(studentDto.getAddress());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setDepartment(studentDto.getDepartment());

        return studentService.saveStudent(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setIdStudent(studentDto.getIdStudent());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAddress(studentDto.getAddress());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setDepartment(studentDto.getDepartment());

        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}