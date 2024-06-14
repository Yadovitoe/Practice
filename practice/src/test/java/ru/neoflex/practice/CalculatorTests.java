package ru.neoflex.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSum() throws Exception {
        this.mockMvc
                .perform(get("/+/3/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    public void shouldReturnDifference() throws Exception {
        this.mockMvc
                .perform(get("/-/9/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("4"));
    }
}