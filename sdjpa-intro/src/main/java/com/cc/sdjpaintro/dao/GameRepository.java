package com.cc.sdjpaintro.dao;

import com.cc.sdjpaintro.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameRepository extends JpaRepository<Game, Long> {
}
