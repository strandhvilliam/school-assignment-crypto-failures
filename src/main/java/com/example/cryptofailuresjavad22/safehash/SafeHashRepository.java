package com.example.cryptofailuresjavad22.safehash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafeHashRepository extends JpaRepository<SafeHashUser, Long> {
}
