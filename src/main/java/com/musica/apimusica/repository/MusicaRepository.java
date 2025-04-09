package com.musica.apimusica.repository;

import com.musica.apimusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {}