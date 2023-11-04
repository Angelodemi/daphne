package it.daphne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.daphne.entity.KitAppartamento;

@Repository
public interface KitAppartamentoRepository extends CrudRepository<KitAppartamento, String>{
	@Query(value= "select id_kit from kit_appartamento where id_appartamento=:id_appartamento",nativeQuery=true)
	List<String> findKitAppartamento(@Param("id_appartamento") String id_appartamento);
}
