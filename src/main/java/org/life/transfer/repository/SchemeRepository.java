package org.life.transfer.repository;

import java.util.UUID;

import org.life.transfer.entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepository extends JpaRepository<Scheme, UUID> {

}
