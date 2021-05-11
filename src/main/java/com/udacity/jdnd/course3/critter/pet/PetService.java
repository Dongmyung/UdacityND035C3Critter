package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public Pet findById(Long petId) {
        Optional<Pet> petOptional = this.petRepository.findById(petId);
        return petOptional.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Pet> findAll() {
        return this.petRepository.findAll();
    }

    public List<Pet> findAllByOwnerId(Long ownerId) {
        return this.petRepository.findAllByOwnerId(ownerId);
    }

    @Transactional
    public Pet addPet(Pet pet) {
        pet = this.petRepository.save(pet);
        Customer owner = pet.getOwner();
        owner.getPets().add(pet);
        this.customerRepository.save(owner);
        return pet;
    }
}
