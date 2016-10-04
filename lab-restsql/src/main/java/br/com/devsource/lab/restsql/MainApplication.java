package br.com.devsource.lab.restsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author guilherme.pacheco
 */
@SpringBootApplication
@Import(InfraConfig.class)
public class MainApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MainApplication.class, args);
  }

}
