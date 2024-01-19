package com.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class AppUtil {

	public String studentCodeGenerator(String stdName) {
		
		String stdCode = stdName.substring(0, 3);
		Random random =new Random();
		int RandomNum = random.nextInt(100000);
		return stdCode +RandomNum;
	}
}
