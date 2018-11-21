package dev.metamorphosis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.metamorphosis.entities.converting.ItemEntity;

@Repository
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {

}
