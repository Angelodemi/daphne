package it.daphne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.Gruppo;

@Repository
public interface GruppoRepository extends CrudRepository<Gruppo, String> {
	
	@Query(value= "select id_appartamento from gruppo_appartamento", nativeQuery=true)
	List<String> findIdAppartamento();
	
	@Query(value= "select id_gruppo from gruppo_appartamento where id_appartamento=:id_appartamento", nativeQuery=true)
	String findIdGruppo(@Param("id_appartamento") String id_appartamento);
	
	@Query(value= "select id_squadra from gruppo where id_gruppo=:id_gruppo", nativeQuery=true)
	String findIdSquadra(@Param("id_gruppo") String id_gruppo);
	
}
