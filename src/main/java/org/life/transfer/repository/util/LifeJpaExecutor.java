package org.life.transfer.repository.util;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;

public interface LifeJpaExecutor<T> {
	
	<R> Optional<R> findOne(Specification<T> spec, Class<R> projectionClass);
	<R> Optional<R> findOne(Specification<T> spec, Class<R> projectionClass, String namedEntityGraph, EntityGraph.EntityGraphType type);
	Optional<T> findOne(Specification<T> spec, String namedEntityGraph, EntityGraph.EntityGraphType type);
	<R> Page<R> findAll(Specification<T> spec, Class<R> projectionClass, String namedEntityGraph, EntityGraph.EntityGraphType type, Pageable pageable);
	Page<T> findAll(Specification<T> sped, String namedEntityGraph, EntityGraph.EntityGraphType type, Pageable pageable);
}
