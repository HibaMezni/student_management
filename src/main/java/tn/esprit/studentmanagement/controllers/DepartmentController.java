package tn.esprit.studentmanagement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.dto.DepartmentDto;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.services.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/Depatment")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(toDepartment(departmentDto));
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(toDepartment(departmentDto));
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    private Department toDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setIdDepartment(departmentDto.getIdDepartment());
        department.setName(departmentDto.getName());
        return department;
    }
}