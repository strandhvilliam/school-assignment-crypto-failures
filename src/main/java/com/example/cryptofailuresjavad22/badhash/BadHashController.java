package com.example.cryptofailuresjavad22.badhash;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/badhash")
public class BadHashController {

  private final BadHashRepository badHashRepository;

  public BadHashController(BadHashRepository badHashRepository) {
    this.badHashRepository = badHashRepository;
  }

  @GetMapping("/admin")
  public List<BadHashUser> getBadHashUsers() {
    return badHashRepository.findAll();

  }
}
