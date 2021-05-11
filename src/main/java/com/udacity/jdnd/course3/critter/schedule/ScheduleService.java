package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CustomerService customerService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, CustomerService customerService) {
        this.scheduleRepository = scheduleRepository;
        this.customerService = customerService;
    }


    public Schedule findById(Long scheduleId) {
        Optional<Schedule> scheduleOptional = this.scheduleRepository.findById(scheduleId);
        return scheduleOptional.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Schedule> findAll() {
        return this.scheduleRepository.findAll();
    }

    public List<Schedule> findAllByPetId(Long petId) {
        return this.scheduleRepository.findAllByPetsId(petId);
    }

    public List<Schedule> findAllByEmployeeId(Long employeeId) {
        return this.scheduleRepository.findAllByEmployeesId(employeeId);
    }

    public List<Schedule> findAllByCustomerId(Long customerId) {
        Customer customer = this.customerService.findById(customerId);
        List<Pet> pets = customer.getPets();
        return this.scheduleRepository.findAllByPetsIn(pets);
    }

    public Schedule save(Schedule schedule) {
        return this.scheduleRepository.save(schedule);
    }
}
