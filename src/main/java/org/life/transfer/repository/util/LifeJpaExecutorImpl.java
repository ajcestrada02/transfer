package org.life.transfer.repository.util;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

public class LifeJpaExecutorImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements LifeJpaExecutor<T>{
	
	public final EntityManager entityManager;
	
	public final SpelAwareProxyProjectionFactory projectionFactory = new SpelAwareProxyProjectionFactory();
	
	public LifeJpaExecutorImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <R> Optional<R> findOne(Specification<T> spec, Class<R> projectionClass) {
		
		return null;
	}

	@Override
	public <R> Optional<R> findOne(Specification<T> spec, Class<R> projectionClass, String namedEntityGraph,
			EntityGraphType type) {
//		TypedQuery<T> query = getQuery(spec, Sort.unsorted());
//        EntityGraph<?> entityGraph = this.entityManager.getEntityGraph(namedEntityGraph);
//        if (entityGraph == null) {
//            throw new LifeJpaException(LifeJpaException.ExceptionNames.NAME_ENTITY_GRAPH_NOT_FOUND, BaseUtils.toJson(entityGraph, true));
//        }
//        query.setHint(type.getKey(), entityGraph);
//        try {
//            T result = query.getSingleResult();
//            return Optional.ofNullable(projectionFactory.createProjection(projectionType, result));
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
		return null;
	}

	@Override
	public Optional<T> findOne(Specification<T> spec, String namedEntityGraph, EntityGraphType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> Page<R> findAll(Specification<T> spec, Class<R> projectionClass, String namedEntityGraph,
			EntityGraphType type, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findAll(Specification<T> sped, String namedEntityGraph, EntityGraphType type, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
