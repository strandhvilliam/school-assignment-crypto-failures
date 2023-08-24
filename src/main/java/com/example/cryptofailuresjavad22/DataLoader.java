package com.example.cryptofailuresjavad22;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.cryptofailuresjavad22.badhash.BadHashRepository;
import com.example.cryptofailuresjavad22.badhash.BadHashUser;
import com.example.cryptofailuresjavad22.badhash.Sha1Hasher;
import com.example.cryptofailuresjavad22.nohash.NoHashRepository;
import com.example.cryptofailuresjavad22.nohash.NoHashUser;
import com.example.cryptofailuresjavad22.safehash.SafeHashRepository;
import com.example.cryptofailuresjavad22.safehash.SafeHashUser;

@Component
public class DataLoader implements CommandLineRunner {

  private final NoHashRepository noHashRepository;
  private final BadHashRepository badHashRepository;
  private final SafeHashRepository safeHashRepository;

  public DataLoader(NoHashRepository noHashRepository, BadHashRepository badHashRepository,
      SafeHashRepository safeHashRepository) {
    this.noHashRepository = noHashRepository;
    this.badHashRepository = badHashRepository;
    this.safeHashRepository = safeHashRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    loadUserData();
  }

  private void loadUserData() throws Exception {
    if (noHashRepository.count() == 0) {

      noHashRepository.save(new NoHashUser("MyFirstUsername", "password123"));
      noHashRepository.save(new NoHashUser("MarioLuigi", "2xz00abc"));
      noHashRepository.save(new NoHashUser("Dinosaur", "rex123"));
      noHashRepository.save(new NoHashUser("BirdMan", "blamesandtalgoxe"));
      noHashRepository.save(new NoHashUser("Dan", "244crush"));

      badHashRepository.save(new BadHashUser("MyFirstUsername", Sha1Hasher.hash("password123")));
      badHashRepository.save(new BadHashUser("MarioLuigi", Sha1Hasher.hash("2xz00abc")));
      badHashRepository.save(new BadHashUser("Dinosaur", Sha1Hasher.hash("rex123")));
      badHashRepository.save(new BadHashUser("BirdMan", Sha1Hasher.hash("blamesandtalgoxe")));
      badHashRepository.save(new BadHashUser("Dan", Sha1Hasher.hash("244crush")));

      Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

      safeHashRepository.save(new SafeHashUser("MyFirstUsername", encoder.encode("password123")));
      safeHashRepository.save(new SafeHashUser("MarioLuigi", encoder.encode("2xz00abc")));
      safeHashRepository.save(new SafeHashUser("Dinosaur", encoder.encode("rex123")));
      safeHashRepository.save(new SafeHashUser("BirdMan", encoder.encode("blamesandtalgoxe")));
      safeHashRepository.save(new SafeHashUser("Dan", encoder.encode("244crush")));

    }
  }

}
