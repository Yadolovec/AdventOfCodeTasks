package com.some.app.EmptyApp.FirstDay;

import com.some.app.EmptyApp.util.Utils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FirstDayTask1 {



	public static void main(String[] args) throws IOException {
		List<Integer> list = Utils.getListFromTextAndAddCalories("src/main/resources/FirstDay.txt");
		System.out.println(Collections.max(list));

	}

}
