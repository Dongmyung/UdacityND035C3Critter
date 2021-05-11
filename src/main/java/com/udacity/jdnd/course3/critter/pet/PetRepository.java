package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Transactional
    List<Pet> findAllByOwnerId(Long ownerId);
}
