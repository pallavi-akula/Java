package com.capg_3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Lab3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		ZonedDateTime ZoneIndia = ZonedDateTime.now();
		System.out.println(ZoneIndia);
		ZonedDateTime ZoneFrance = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(ZoneFrance);
		ZonedDateTime ZoneTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println(ZoneTokyo);
		ZonedDateTime ZoneNew_York = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(ZoneNew_York);
		


		
	}

}
