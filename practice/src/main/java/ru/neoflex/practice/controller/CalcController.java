package ru.neoflex.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @GetMapping("/+/{a}/{b}")
    public Integer add(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a + b;
    }

    @GetMapping("/-/{a}/{b}")
    public Integer subtract(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return a - b;
    }
}