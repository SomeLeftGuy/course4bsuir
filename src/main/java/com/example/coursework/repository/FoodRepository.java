package com.example.coursework.repository;

import com.example.coursework.model.entity.Animal;
import com.example.coursework.model.entity.Food;
import com.example.coursework.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> getBySuppliersEquals(Supplier supplier);

    List<Food> getByAnimalsEquals(Animal animal);
}
