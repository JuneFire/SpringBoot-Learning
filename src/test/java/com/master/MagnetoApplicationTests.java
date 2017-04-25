package com.master;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@SpringBootApplication
public class MagnetoApplicationTests {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	@Test
	public void contextLoads() {
	}

}
