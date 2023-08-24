package com.example.cryptofailuresjavad22.badhash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadHashRepository extends JpaRepository<BadHashUser, Long> {
}
