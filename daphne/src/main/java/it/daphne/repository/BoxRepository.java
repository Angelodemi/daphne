package it.daphne.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.Box;

@Repository
public interface BoxRepository extends CrudRepository<Box, String>{
	@Query(value= "select id_warehouse from appartamento where id=:id_appartamento")
	String findWarehouse(@Param("id_appartamento") String id_appartamento);
}
