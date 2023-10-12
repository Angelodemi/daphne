package it.daphne.repository;

import org.springframework.data.repository.CrudRepository;

import it.daphne.entity.Gruppo;
import it.daphne.entity.GruppoCap;

public interface GruppoCapRepository extends CrudRepository<GruppoCap, String> {

}
