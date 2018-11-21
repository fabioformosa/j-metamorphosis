package dev.metamorphosis.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import dev.metamorphosis.jpa.entities.converting.SimpleEntity;

@Component
public class SimpleJpaRepositoryImpl implements SimpleJpaRepository {

  @Override
  public List<SimpleEntity> findAll() {
    return null;
  }

  @Override
  public List<SimpleEntity> findAll(Sort sort) {
    return null;
  }

  @Override
  public List<SimpleEntity> findAllById(Iterable<Long> ids) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public void flush() {
  }

  @Override
  public <S extends SimpleEntity> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public void deleteInBatch(Iterable<SimpleEntity> entities) {

  }

  @Override
  public void deleteAllInBatch() {
  }

  @Override
  public SimpleEntity getOne(Long id) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public Page<SimpleEntity> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> S save(S entity) {
    return null;
  }

  @Override
  public Optional<SimpleEntity> findById(Long id) {
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
  public void delete(SimpleEntity entity) {
  }

  @Override
  public void deleteAll(Iterable<? extends SimpleEntity> entities) {
  }

  @Override
  public void deleteAll() {
  }

  @Override
  public <S extends SimpleEntity> Optional<S> findOne(Example<S> example) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends SimpleEntity> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends SimpleEntity> boolean exists(Example<S> example) {
    return false;
  }

}
