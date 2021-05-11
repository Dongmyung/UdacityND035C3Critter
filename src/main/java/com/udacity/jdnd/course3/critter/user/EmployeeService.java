package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(Long employeeId) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employeeId);
        return employeeOptional.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public List<Employee> findAllBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, LocalDate date) {
        List<Employee> availableEmployee = new ArrayList<>();
        List<Employee> dayMatchingEmployee = this.employeeRepository.findAllByDaysAvailable(date.getDayOfWeek());
        for (Employee e : dayMatchingEmployee) {
            if (e.getSkills().containsAll(skills)) {
                availableEmployee.add(e);
            }
        }
        return availableEmployee;
    }

    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

}
