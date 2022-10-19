package com.example.Vacation_pay_calculator.controller;

import com.example.Vacation_pay_calculator.service.CalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CalculateController {
    private final LocalDate dateNow = LocalDate.now().plusDays(1);

    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }


    @GetMapping("/calculate")
    public String calculate() {
        return "calculate";
    }

    @PostMapping("/calculate")
    public String main(
            @RequestParam String calendar1,
            @RequestParam String calendar2,
            @RequestParam(required = false, defaultValue = "0") Integer salary,
            Model model
    ) {

        LocalDate localDateStart = LocalDate.parse(calendar1);
        LocalDate localDateEnd = LocalDate.parse(calendar2);
        if (localDateEnd.isBefore(localDateStart)
                || dateNow.isAfter(localDateStart)
                || dateNow.isAfter(localDateEnd)
        ) {
            model.addAttribute("isNotTry", "Вы указали неправильную дату");
            return "calculate";
        }

        double attributeValue = calculateService.vacationPay(salary, localDateStart, localDateEnd);
        model.addAttribute("vacation_pay", String.format("%.2f", attributeValue));
        return "main";
    }

}
