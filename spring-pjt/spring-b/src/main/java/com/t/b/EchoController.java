package com.t.b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class EchoController {
  @Bean
  public RouterFunction<ServerResponse> echo() {
    return RouterFunctions
        .route(request -> true, request -> {
          log.info("req >> {}", request.path());
          return ServerResponse.ok().build();
        });
  }
}
