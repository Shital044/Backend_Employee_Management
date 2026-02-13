package com.company.employeemanagement.service;

import com.company.employeemanagement.entity.Employee;
import com.company.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee save(Employee e) {
        return repo.save(e);
    }

    public void delete(Long id) {
        Employee emp = getById(id);

        repo.findAll().forEach(e -> {
            if (e.getManager() != null && e.getManager().getId().equals(id)) {
                e.setManager(null);
                repo.save(e);
            }
        });

        repo.delete(emp);
    }
}
