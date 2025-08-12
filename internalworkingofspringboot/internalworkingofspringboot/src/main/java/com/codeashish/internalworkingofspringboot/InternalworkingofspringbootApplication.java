package com.codeashish.internalworkingofspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalworkingofspringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalworkingofspringbootApplication.class, args);
	}

	//@Autowired

	public final PaymentService PaymentService;

	public InternalworkingofspringbootApplication(PaymentService PaymentService){
		this.PaymentService = PaymentService;
	}

	@Override
	public void run(String... args) throws Exception {

		String payment = PaymentService.pay();
		System.out.println(payment);
		System.out.println("Application has started successfully.");
		System.out.println("This is a simple Spring Boot application demonstrating Razorpay payment service.");
		System.out.println("You can extend this application with more features as needed.");
		System.out.println("Thank you for using this application!");
		System.out.println("Have a great day!");
		System.out.println("Goodbye!");
		System.exit(0);
	}
}
