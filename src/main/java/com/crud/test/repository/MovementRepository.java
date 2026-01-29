package com.crud.test.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.test.domain.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

}
