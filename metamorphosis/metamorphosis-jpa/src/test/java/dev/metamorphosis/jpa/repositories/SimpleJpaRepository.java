package dev.metamorphosis.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.metamorphosis.jpa.entities.converting.SimpleEntity;

@Repository
public interface SimpleJpaRepository extends JpaRepository<SimpleEntity, Long> {

}
