package com.github.daggerok.es.command;

import com.github.daggerok.es.api.Command;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class Sender<C extends Command> {
  public void send(C command) {
    log.debug("sending: {}", command);
  }
}
