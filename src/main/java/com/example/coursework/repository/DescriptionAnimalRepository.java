package com.example.coursework.repository;

import com.example.coursework.model.entity.Animal;
import com.example.coursework.model.entity.DescriptionAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionAnimalRepository extends JpaRepository<DescriptionAnimal, Integer> {
    List<DescriptionAnimal> findByAnimalEquals(Animal animal);
}
