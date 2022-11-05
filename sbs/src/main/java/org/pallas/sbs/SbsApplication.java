package org.pallas.sbs;

import org.apache.catalina.core.ApplicationContext;
import org.pallas.sbs.controller.ElsoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SbsApplication.class, args);
		ElsoController elso = ctx.getBean(ElsoController.class);
		elso.display();
	}

}
