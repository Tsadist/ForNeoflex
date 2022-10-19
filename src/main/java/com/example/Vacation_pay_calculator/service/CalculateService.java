package com.example.Vacation_pay_calculator.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculateService {

    public double vacationPay(int salary, LocalDate localDateStart, LocalDate localDateEnd) {
        Period period = localDateStart.until(localDateEnd);
        int holiday = this.countHoliday(localDateStart, localDateEnd);

        int days = period.getDays() - holiday + 1;
        return (salary / 21.0) * days;
    }

    protected int countHoliday(LocalDate localDateStart, LocalDate localDateEnd) {
        int countHoliday = 0;

        for (LocalDate i = localDateStart; i.isBefore(localDateEnd); i = i.plusDays(1)) {
            int day = i.getDayOfWeek().getValue();
            if (day == 6 || day == 7) {
                countHoliday++;
            }
        }
        return countHoliday;
    }
}
