package dev.metamorphosis.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.metamorphosis.jpa.entities.converting.ItemEntity;

@Repository
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {

}
