package it.daphne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.Appartamento;


@Repository
public interface AppartamentoRepository extends CrudRepository<Appartamento, String> {
	@Query(value= "select id_warehouse from appartamento where id=:id_appartamento")
	String findWarehouse(@Param("id_appartamento") String id_appartamento);
	
	@Query(value= "select distinct id from appartamento")
	List<String> findAllId();
	
}
