package com.example.Vacation_pay_calculator.service;

import com.example.Vacation_pay_calculator.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CalculateServiceTest {

    private final CalculateService calculateService = new CalculateService();
    private final LocalDate start = LocalDate.parse("2022-10-15");
    private final LocalDate end = LocalDate.parse("2022-10-20");

    @Test
    public void testVacationPay() {
        int salary = 21000;
        double result = 4000;
        Assertions.assertEquals(result, calculateService.vacationPay(salary, start, end));
    }

    @Test
    public void testCountHoliday() {
        int result = 2;
        Assertions.assertEquals(result, calculateService.countHoliday(start, end));

    }

}
