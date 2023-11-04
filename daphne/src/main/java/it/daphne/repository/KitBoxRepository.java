package it.daphne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.KitBox;

@Repository
public interface KitBoxRepository extends CrudRepository<KitBox, String>{
	
}
