package com.example.musica.repository;

import com.example.musica.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanzoneRepository extends JpaRepository<Canzone, Long> {
}
