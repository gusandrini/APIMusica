package com.musica.apimusica.repository;

import com.musica.apimusica.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
