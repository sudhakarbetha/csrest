package com.opentext.csrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.opentext.csrest")
@SpringBootApplication
public class CsrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrestApplication.class, args);
	}
}
