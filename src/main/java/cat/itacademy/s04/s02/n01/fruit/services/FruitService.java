package cat.itacademy.s04.s02.n01.fruit.services;

import cat.itacademy.s04.s02.n01.fruit.dto.FruitDTO;
import cat.itacademy.s04.s02.n01.fruit.model.Fruit;

import java.util.List;

public interface FruitService {

    Fruit createFruit(FruitDTO fruitDTO);

    Fruit updateFruit(Long id, FruitDTO fruitDTO);

    void removeFruit(Long id);

    Fruit getFruitById(Long id);

    List<Fruit> getAllFruits();
}
