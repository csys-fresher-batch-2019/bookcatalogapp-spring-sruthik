package com.sruthi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan("com.sruthi.bookcatalogapp")
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)

public class BookCatalogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogAppApplication.class, args);
	}
	
	
	

}
