package com.guigui_chan.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query(value = "SELECT * FROM videos WHERE title LIKE CONCAT('%', :term, '%')", nativeQuery = true)
    Optional<List<Video>> findByTermInTitle(String term);
}