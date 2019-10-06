package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启动spring boot自动装配
//@EnableAutoConfiguration
public class HelloworldApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args) ;
	}
}
