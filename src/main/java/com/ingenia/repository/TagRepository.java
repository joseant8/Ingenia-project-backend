package com.ingenia.repository;

import com.ingenia.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Boolean existsByNombre(String nombre);

    Optional<Tag> findByNombre(String nombre);
}
