package com.company.employeemanagement.service;

import com.company.employeemanagement.repository.DepartmentRepository;
import com.company.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;

    public DepartmentService(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        this.deptRepo = deptRepo;
        this.empRepo = empRepo;
    }

    public void delete(Long id) {
        boolean exists = empRepo.findAll()
                .stream()
                .anyMatch(e -> e.getDepartment().getId().equals(id));

        if (exists) throw new RuntimeException("Department has employees");

        deptRepo.deleteById(id);
    }
}
