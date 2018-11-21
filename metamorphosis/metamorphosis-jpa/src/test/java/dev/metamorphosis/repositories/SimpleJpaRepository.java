package dev.metamorphosis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.metamorphosis.entities.converting.SimpleEntity;

@Repository
public interface SimpleJpaRepository extends JpaRepository<SimpleEntity, Long> {

}
