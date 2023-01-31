package com.some.app.EmptyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class EmptyAppApplication {



	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/FirstDay.txt"));
			String s;

			List<Integer> list = new ArrayList<>();
			list.add(0);
			int i = 0;

			while ((s = br.readLine())!=null){
				if (s.isBlank()){
					i++;
					list.add(0);
				} else {
					list.set(i, (list.get(i)+Integer.parseInt(s)));
				}
			}

//			for (Integer j : list){
//				System.out.println(j);
//			}

			System.out.println(Collections.max(list));



		} catch (Exception e){}


	}

}
