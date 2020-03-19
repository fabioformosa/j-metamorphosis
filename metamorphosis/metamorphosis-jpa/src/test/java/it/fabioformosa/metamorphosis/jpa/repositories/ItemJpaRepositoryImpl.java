package it.fabioformosa.metamorphosis.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;

@Component
public class ItemJpaRepositoryImpl implements ItemJpaRepository {

  @Override
  public List<ItemEntity> findAll() {
    return null;
  }

  @Override
  public List<ItemEntity> findAll(Sort sort) {
    return null;
  }

  @Override
  public List<ItemEntity> findAllById(Iterable<Long> ids) {
    return null;
  }

  @Override
  public <S extends ItemEntity> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public void flush() {
  }

  @Override
  public <S extends ItemEntity> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public void deleteInBatch(Iterable<ItemEntity> entities) {

  }

  @Override
  public void deleteAllInBatch() {
  }

  @Override
  public ItemEntity getOne(Long id) {
    return null;
  }

  @Override
  public <S extends ItemEntity> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends ItemEntity> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public Page<ItemEntity> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public <S extends ItemEntity> S save(S entity) {
    return null;
  }

  @Override
  public Optional<ItemEntity> findById(Long id) {
    return null;
  }

  @Override
  public boolean existsById(Long id) {
    return false;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long id) {
  }

  @Override
  public void delete(ItemEntity entity) {
  }

  @Override
  public void deleteAll(Iterable<? extends ItemEntity> entities) {
  }

  @Override
  public void deleteAll() {
  }

  @Override
  public <S extends ItemEntity> Optional<S> findOne(Example<S> example) {
    return null;
  }

  @Override
  public <S extends ItemEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends ItemEntity> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends ItemEntity> boolean exists(Example<S> example) {
    return false;
  }

}
