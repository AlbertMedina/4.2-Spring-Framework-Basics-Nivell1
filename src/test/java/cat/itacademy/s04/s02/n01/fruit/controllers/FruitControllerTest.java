package cat.itacademy.s04.s02.n01.fruit.controllers;

import cat.itacademy.s04.s02.n01.fruit.dto.FruitDTO;
import cat.itacademy.s04.s02.n01.fruit.model.Fruit;
import cat.itacademy.s04.s02.n01.fruit.repository.FruitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FruitRepository fruitRepository;

    @BeforeEach
    void cleanDB() {
        fruitRepository.deleteAll();
    }

    @Test
    void getFruits_returnsEmptyListInitially() throws Exception {
        mockMvc.perform(get("/fruits")).andExpect(status().isOk()).andExpect(content().json("[]"));
    }

    @Test
    void createFruit_returnsFruitWithId() throws Exception {
        mockMvc.perform(post("/fruits").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(new FruitDTO("Watermelon", 2))))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(notNullValue())).andExpect(jsonPath("$.name").value("Watermelon")).andExpect(jsonPath("$.weightInKg").value(2));
    }

    @Test
    void getFruitById_returnsCorrectFruit() throws Exception {
        String response = mockMvc.perform(post("/fruits").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(new FruitDTO("Watermelon", 2))))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

        Fruit fruit = objectMapper.readValue(response, Fruit.class);

        mockMvc.perform(get("/fruits/{id}", fruit.getId())).andExpect(jsonPath("$.id").value(notNullValue())).andExpect(jsonPath("$.name").value("Watermelon")).andExpect(jsonPath("$.weightInKg").value(2));
    }
}
