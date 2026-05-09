package it.fabioformosa.metamorphosis.jpa.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.jpa.entities.converting.SimpleEntity;

@Component
@SuppressWarnings("deprecation")
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
  public <S extends SimpleEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteInBatch(Iterable<SimpleEntity> entities) {

  }

  @Override
  public void deleteAllInBatch(Iterable<SimpleEntity> entities) {
  }

  @Override
  public void deleteAllInBatch() {
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> ids) {
  }

  @Override
  public SimpleEntity getOne(Long id) {
    return null;
  }

  @Override
  public SimpleEntity getById(Long id) {
    return null;
  }

  @Override
  public SimpleEntity getReferenceById(Long id) {
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
    SimpleEntity simpleEntity = new SimpleEntity();
    simpleEntity.setId(id);
    return Optional.of(simpleEntity);
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
  public void deleteAllById(Iterable<? extends Long> ids) {
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

  @Override
  public <S extends SimpleEntity, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

}
