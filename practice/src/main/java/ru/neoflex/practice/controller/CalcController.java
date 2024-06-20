package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.practice.model.CalculationResult;
import ru.neoflex.practice.repository.CalculationResultRepository;

import java.util.List;

@RestController
@RequestMapping("/api/calc")
public class CalcController {

    @Autowired
    private CalculationResultRepository calculationResultRepository;

    @GetMapping("/+/{a}/{b}")
    public CalculationResult add(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        Integer result = a + b;
        CalculationResult calculationResult = new CalculationResult("add", a, b, result);
        return calculationResultRepository.save(calculationResult);
    }

    @GetMapping("/-/{a}/{b}")
    public CalculationResult subtract(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        Integer result = a - b;
        CalculationResult calculationResult = new CalculationResult("subtract", a, b, result);
        return calculationResultRepository.save(calculationResult);
    }

    @GetMapping("/all")
    public List<CalculationResult> getAllResults() {
        return calculationResultRepository.findAll();
    }
}