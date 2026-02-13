package com.company.employeemanagement.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employeemanagement.entity.Department;
import com.company.employeemanagement.repository.DepartmentRepository;
import com.company.employeemanagement.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository repo;
    private final DepartmentService service;

    public DepartmentController(DepartmentRepository repo, DepartmentService service) {
        this.repo = repo;
        this.service = service;
    }

    @PostMapping
    public Department create(@RequestBody Department d) {
        return repo.save(d);
    }

    @GetMapping
    public List<Department> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
