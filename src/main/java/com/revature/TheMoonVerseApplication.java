package com.revature;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Users;

@SpringBootApplication
public class TheMoonVerseApplication {
	{LocalDate date = LocalDate.of(1988, 06, 10);
	
	Users a = new Users(1, "rev@yahoo.com","password","Joe","Doe",1,false,date);
	}
	public static void main(String[] args) {
		SpringApplication.run(TheMoonVerseApplication.class, args);
	
	}

}
