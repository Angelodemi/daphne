package it.daphne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.Kit;

@Repository
public interface KitRepository extends CrudRepository<Kit, String>{
	@Query(value= "select id from kit where id=:id and categoria1='B'" , nativeQuery=true)
	String findCategoriaB(@Param("id") String id);
	
	@Query(value= "select id from kit where categoria1='D'", nativeQuery=true)
	List<String> findCategoriaD();
	
	@Query(value= "select id from kit where categoria1='C'", nativeQuery=true)
	List<String> findCategoriaC(/*@Param("numero_notti") int numero_notti, @Param("num_ospiti") int num_ospiti*/);
}
