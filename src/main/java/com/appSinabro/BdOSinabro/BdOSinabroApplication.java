package com.appSinabro.BdOSinabro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("com.appSinabro.BdOSinabro.model")
@SpringBootApplication(scanBasePackages = "com.appSinabro.BdOSinabro.*")
public class BdOSinabroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdOSinabroApplication.class, args);
	}

}
