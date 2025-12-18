package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Mock employee database using a map
    private final Map<UUID, Employee> employeeMap = new ConcurrentHashMap<>();

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        return employeeMap.get(uuid);
    }

    public Employee createEmployee(Employee newEmployee) {
        // Assign a new UUID if not provided
        if (newEmployee.getUuid() == null) {
            newEmployee.setUuid(UUID.randomUUID());
        }
        // Add employee to the mock database (map)
        employeeMap.put(newEmployee.getUuid(), newEmployee);
        return newEmployee;
    }
}
