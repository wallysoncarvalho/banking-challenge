package info.wallyson.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"info.wallyson.rest", "info.wallyson.persistence"})
@EnableJpaRepositories("info.wallyson.persistence")
@EntityScan("info.wallyson.persistence")
public class RestApp {
  public static void main(String[] args) {
    SpringApplication.run(RestApp.class, args);
  }
}
