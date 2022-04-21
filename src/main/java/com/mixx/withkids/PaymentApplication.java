package com.mixx.withkids;

import com.mixx.withkids.domain.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentApplication {

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(PaymentApplication.class, args);

		PaymentRepository repository = applicationContext.getBean(PaymentRepository.class);

		Payment payment = new Payment();
		payment.setAmount(Long.valueOf(10000));
		payment.setStatus(Status.진행중);
		payment.setPayType(PayType.카드);
		payment.setReservationId("A01");

		repository.save(payment);

		// System.out.println(repository.findById(Long.valueOf(1)).get().getReservationId() == "A01");
	}

}
