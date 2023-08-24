package com.dedalus.codingtaskbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analyse")
@CrossOrigin(origins = "http://localhost:4200")
public class TextEndpoint {

  private final TextService service;

  @Autowired
  public TextEndpoint(TextService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public TextDto analyse(@RequestBody TextDto text) {
    return service.analyse(text.vowels(), text.text());
  }
}
