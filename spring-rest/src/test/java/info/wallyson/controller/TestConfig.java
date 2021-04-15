package info.wallyson.controller;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
    basePackages = {
      "info.wallyson.rest.controller",
      "info.wallyson.rest.config",
      "info.wallyson.rest.exception"
    })
class TestConfig {}
