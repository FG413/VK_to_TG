package com.example.NL_MessageBot;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


	@SpringBootApplication
	public class NlMessageBotApplication {

		public static void main(String[] args) throws ClientException, ApiException {

		SpringApplication.run(NlMessageBotApplication.class, args);


	}

}
