package cat.itacademy.s04.s02.n01.fruit.controllers;

import cat.itacademy.s04.s02.n01.fruit.model.Fruit;
import cat.itacademy.s04.s02.n01.fruit.services.FruitServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitServiceImpl fruitService;

    public FruitController(FruitServiceImpl fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruits")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruitRequest) {
        String name = fruitRequest.getName();
        int weightInKg = fruitRequest.getWeightInKg();

        if (name == null || name.isBlank() || weightInKg <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Fruit fruit = fruitService.createFruit(name, weightInKg);
        return ResponseEntity.status(HttpStatus.CREATED).body(fruit);
    }

    @PutMapping("/fruits/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody Fruit fruitRequest) {
        String name = fruitRequest.getName();
        int weightInKg = fruitRequest.getWeightInKg();

        if (name == null || name.isBlank() || weightInKg <= 0) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Fruit updated = fruitService.updateFruit(id, name, weightInKg);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/fruits/{id}")
    public ResponseEntity<Void> removeFruit(@PathVariable Long id) {
        try {
            fruitService.removeFruit(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fruits/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        try {
            Fruit fruit = fruitService.getFruitById(id);
            return ResponseEntity.ok(fruit);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }
}
