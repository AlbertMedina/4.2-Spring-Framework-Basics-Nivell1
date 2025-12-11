package cat.itacademy.s04.s02.n01.fruit.controllers;

import cat.itacademy.s04.s02.n01.fruit.model.Fruit;
import cat.itacademy.s04.s02.n01.fruit.services.FruitServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitServiceImpl fruitService;

    public FruitController(FruitServiceImpl fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruits")
    public Fruit addFruit(@RequestBody Fruit fruitRequest) {
        return fruitService.createFruit(fruitRequest.getName(), fruitRequest.getWeightInKg());
    }

    @PutMapping("/fruits/{id}")
    public Fruit updateFruit(@PathVariable Long id, @RequestBody Fruit fruitRequest) {
        return fruitService.updateFruit(id, fruitRequest.getName(), fruitRequest.getWeightInKg());
    }

    @DeleteMapping("/fruits/{id}")
    public void removeFruit(@PathVariable Long id) {
        fruitService.removeFruit(id);
    }

    @GetMapping("/fruits/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return fruitService.getFruitById(id);
    }

    @GetMapping("/fruits")
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }
}
