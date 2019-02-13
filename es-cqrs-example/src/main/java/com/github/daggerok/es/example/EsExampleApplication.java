package com.github.daggerok.es.example;

import com.github.daggerok.es.api.EsApiAutoConfiguration;
import com.github.daggerok.es.command.EsCommandAutoConfiguration;
import com.github.daggerok.es.h2.EsH2AutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({
    EsH2AutoConfiguration.class,
    EsApiAutoConfiguration.class,
    EsCommandAutoConfiguration.class,
})
@SpringBootApplication
public class EsExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(EsExampleApplication.class, args);
  }
}
