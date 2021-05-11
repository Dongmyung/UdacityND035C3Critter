package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Transactional
    List<Schedule> findAllByEmployeesId(Long EmployeesId);

    @Transactional
    List<Schedule> findAllByPetsId(Long petsId);

    @Transactional
    List<Schedule> findAllByPetsIn(List<Pet> pets);
}
