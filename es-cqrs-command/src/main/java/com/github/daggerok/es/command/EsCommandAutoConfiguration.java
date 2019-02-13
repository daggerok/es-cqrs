package com.github.daggerok.es.command;

import com.github.daggerok.es.api.EsApiAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({
    EsApiAutoConfiguration.class,
})
@SpringBootApplication
public class EsCommandAutoConfiguration {

  public static void main(String[] args) {
    //
  }
}
