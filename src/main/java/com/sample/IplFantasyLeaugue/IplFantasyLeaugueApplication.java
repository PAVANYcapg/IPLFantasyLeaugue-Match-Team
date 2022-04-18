package com.sample.IplFantasyLeaugue;

import java.util.List;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.model.Match;

@SpringBootApplication(scanBasePackages = {"com.model","com.dao","com.controller"})

@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
public class IplFantasyLeaugueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplFantasyLeaugueApplication.class, args);
	}

}
