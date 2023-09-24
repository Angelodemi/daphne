package it.daphne.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.daphne.entity.InterventoPulizia;
import it.daphne.entity.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, String> {
	List<Prenotazione> getByIdAppartamento(String idAppartamento);
	
	@Query(value = "select * from prenotazione", nativeQuery = true)
	List<Prenotazione> findAllPrenotazione();
	
//	@Query(value = "select * from appartamento a WHERE a.id=?1", nativeQuery = true)
//	List<InterventoPulizia> findIdAppartamento(String id);
	
	@Query(value = "select * from prenotazione a WHERE  DATEDIFF ( day , trunc(check_in)  , trunc(sysdate()) ) >  0", nativeQuery = true)
	List<Prenotazione> findPrenotazioniDopoOggi();
}
