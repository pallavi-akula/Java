package com.capg_3;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Lab3_4 {
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(1947,  Month.DECEMBER, 23);
		LocalDate end = LocalDate.of(1970,  Month.MARCH, 25);
		Period p = start.until(end);
		System.out.println("Days : "+p.getDays());
		System.out.println("Months : "+p.getMonths());
		System.out.println("Years : "+p.getYears());
	}

}
