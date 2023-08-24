package com.example.cryptofailuresjavad22.nohash;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nohash")
public class NoHashController {

  private final NoHashRepository noHashRepository;

  public NoHashController(NoHashRepository noHashRepository) {
    this.noHashRepository = noHashRepository;
  }

  @GetMapping("/admin")
  public List<NoHashUser> getNoHashUsers() {
    return noHashRepository.findAll();

  }
}
