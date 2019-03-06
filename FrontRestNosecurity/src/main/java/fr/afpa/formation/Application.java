package fr.afpa.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//SpringBootServletInitializer and the override for generating war
@SpringBootApplication(scanBasePackages="fr.afpa.formation")
public class Application extends SpringBootServletInitializer /*WebMvcConfigurer*/  {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}
