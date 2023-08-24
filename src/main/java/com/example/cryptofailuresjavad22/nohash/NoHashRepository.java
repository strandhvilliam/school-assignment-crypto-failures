package com.example.cryptofailuresjavad22.nohash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoHashRepository extends JpaRepository<NoHashUser, Long> {
}
