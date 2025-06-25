package com.ipeksavas.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ipeksavas.configuration.GlobalProperties;


@SpringBootApplication
@EntityScan(basePackages = {"com.ipeksavas"})
@ComponentScan(basePackages = {"com.ipeksavas"})
@EnableJpaRepositories(basePackages = {"com.ipeksavas"})
@EnableConfigurationProperties(value = GlobalProperties.class)//configuratin propertiesi aktive et

public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
