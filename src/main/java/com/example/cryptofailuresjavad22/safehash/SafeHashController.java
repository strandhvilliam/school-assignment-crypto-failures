package com.example.cryptofailuresjavad22.safehash;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/safehash")
public class SafeHashController {

  private final SafeHashRepository safeHashRepository;

  public SafeHashController(SafeHashRepository safeHashRepository) {
    this.safeHashRepository = safeHashRepository;
  }

  @GetMapping("/admin")
  public List<SafeHashDto> getNoHashUsers() {
    List<SafeHashUser> entities = safeHashRepository.findAll();

    return entities.stream().map(entity -> new SafeHashDto(entity.getUsername())).toList();

  }
}
