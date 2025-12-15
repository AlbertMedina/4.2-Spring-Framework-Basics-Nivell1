package cat.itacademy.s04.s02.n01.fruit.services;

import cat.itacademy.s04.s02.n01.fruit.dto.FruitDTO;
import cat.itacademy.s04.s02.n01.fruit.model.Fruit;
import cat.itacademy.s04.s02.n01.fruit.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit createFruit(FruitDTO fruitDTO) {
        Fruit fruit = new Fruit(fruitDTO.getName(), fruitDTO.getWeightInKg());
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Long id, FruitDTO fruitDTO) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit " + id + "not found"));
        fruit.setName(fruitDTO.getName());
        fruit.setWeightInKg(fruitDTO.getWeightInKg());
        return fruitRepository.save(fruit);
    }

    @Override
    public void removeFruit(Long id) {
        if (!fruitRepository.existsById(id)) {
            throw new RuntimeException("Fruit " + id + "not found");
        }
        fruitRepository.deleteById(id);
    }

    @Override
    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit " + id + "not found"));
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
