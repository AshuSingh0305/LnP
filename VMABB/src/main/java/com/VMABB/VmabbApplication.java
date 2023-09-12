package com.VMABB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Check.Ashu;

@SpringBootApplication
public class VmabbApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmabbApplication.class, args);
		Ashu ashu = new Ashu();
		ashu.start();
		System.out.println("yo mama fat");
	}

}
