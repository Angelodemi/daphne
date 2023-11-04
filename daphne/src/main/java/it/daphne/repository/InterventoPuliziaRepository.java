package it.daphne.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.daphne.entity.InterventoPulizia;
import it.daphne.entity.InterventoPuliziaId;

@Repository
public interface InterventoPuliziaRepository extends CrudRepository<InterventoPulizia, InterventoPuliziaId> {
	@Query(value = "select u.id_intervento_pulizia,u.id_appartamento,u.id_prenotazione,u.data_intervento,u.orario,u.num_volte_inserito from intervento_pulizia u,appartamento a WHERE u.data_intervento = ?1 and a.id_warehouse=?2 and a.id=u.id_appartamento", nativeQuery = true)
	List<InterventoPulizia> findAllInterventiPulizia(Date data,String idWarehouse);
	
	@Query(value = "select data_intervento from intervento_pulizia  WHERE id_prenotazione = :idSucc ", nativeQuery = true)
	List<Date> findAllInverventiFromId(@Param("idSucc") String idSucc);
	
	@Query(value = "select id_intervento_pulizia from intervento_pulizia  WHERE eliminato=true ", nativeQuery = true)
	List<String> findAllInverventiEliminati();
	
	@Query(value = "select * from intervento_pulizia  WHERE date(data_intervento)=date(sysdate()) ", nativeQuery = true)	
	List<InterventoPulizia> findAllInterventiOggi();
	
	@Query(value = "select id_prenotazione from intervento_pulizia  WHERE id_appartamento=:id_appartamento ", nativeQuery = true)	
	String findIdPrenotazione(@Param("id_appartamento") String id_appartamento);
	
	@Modifying
	@Transactional
	@Query(value = "update intervento_pulizia set eliminato=true WHERE date(u.data_intervento) = date(sysdate()) ", nativeQuery = true)
	void setEliminatollInterventiPuliziaDelGiorno();
	
	@Modifying
	@Transactional
	@Query(value = "delete from intervento_pulizia  WHERE id_intervento_pulizia=:id and DATEDIFF ( day , date(data_intervento)  , date(sysdate()) ) >  0", nativeQuery = true)
	void deleteAllInterventiPuliziaEliminati(@Param("id") String id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from intervento_pulizia i where i.idPrenotazione=:id_prenotazione and i.data=:data")
	void deleteIntervento(@Param("id_prenotazione") String id_prenotazione,@Param("data") Date data);
	
	@Modifying
	@Transactional
	@Query(value = "delete from intervento_pulizia  WHERE DATEDIFF ( day , date(data_intervento)  , date(sysdate()) ) >  0", nativeQuery = true)
	void deleteAllInterventiPuliziaDopoOggi();


}

