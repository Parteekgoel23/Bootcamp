package com.cg.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a main class that run the project
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/


@SpringBootApplication
public class PaymentWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentWalletApplication.class, args);
	}
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
