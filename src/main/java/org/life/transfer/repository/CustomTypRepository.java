package org.life.transfer.repository;

import java.util.UUID;

import org.life.transfer.entity.CustomTyp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomTypRepository extends JpaRepository<CustomTyp, UUID>{

	public CustomTyp findByCstmTypId(String cstmTypId);
	
}
