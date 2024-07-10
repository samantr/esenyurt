package com.esenyurt.app;

import com.esenyurt.audit.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.esenyurt.controller com.esenyurt.service com.esenyurt.exception com.esenyurt.config  com.esenyurt.audit ")
@EntityScan("com.esenyurt.entity com.esenyurt.view")
@EnableJpaRepositories("com.esenyurt.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class AppApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
