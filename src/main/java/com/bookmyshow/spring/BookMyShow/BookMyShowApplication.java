package com.bookmyshow.spring.BookMyShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.List;

//import springfox.documentation.swagger2.annotations.*;

//@EnableSwagger2
@SpringBootApplication
public class BookMyShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);

		/*
File f=new File("S:\\Nitin_Resume");

		List<File> listoffiles=Arrays.asList(f.listFiles());
		listoffiles.stream().anyMatch(item -> item.getName().equals("A"))
				THis is the both the way to write a code above one is to use anyMatch to break a loop below is just normal for loop
        boolean b = false;
        for (File item : listoffiles) {
            if (item.getName().equals("A")) {
                b = true;
                break;
            }
        }
        System.out.println(b);*/
	}
}
