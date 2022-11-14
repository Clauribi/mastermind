package com.example.demo.api.repositories;

import com.example.demo.api.domain.Guess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Integer> {
}
