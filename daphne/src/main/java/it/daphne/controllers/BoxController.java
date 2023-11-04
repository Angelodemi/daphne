package it.daphne.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.daphne.entity.Box;
import it.daphne.entity.KitBox;
import it.daphne.entity.Prenotazione;
import it.daphne.repository.BoxRepository;
import it.daphne.repository.GruppoRepository;
import it.daphne.repository.InterventoPuliziaRepository;
import it.daphne.repository.KitAppartamentoRepository;
import it.daphne.repository.KitBoxRepository;
import it.daphne.repository.KitRepository;
import it.daphne.repository.PrenotazioneRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/box") // T
public class BoxController {
		 @Autowired // This means to get the bean called userRepository
	     // Which is auto-generated by Spring, we will use it to handle the data
	private PrenotazioneRepository prenotazioneRepository;
	
	@Autowired
	private InterventoPuliziaRepository interventoPuliziaRepository;
	
	@Autowired
	private BoxRepository boxRepository;
	
	@Autowired
	private GruppoRepository gruppoRepository;
	
	@Autowired
	private KitAppartamentoRepository kitAppartamentoRepository;
	
	@Autowired
	private KitRepository kitRepository;
	
	@Autowired
	private KitBoxRepository kitBoxRepository;
	
	private Map<String,List<String>> gruppo= new HashMap<>();
	
	@PostMapping(path="/creazioneBox") // Map ONLY POST Requests
	private void creazioneBox() throws IOException, ParseException {
		Box box=new Box();
		List<String> idAppartamenti= gruppoRepository.findIdAppartamento();
		for(String idAppartamento: idAppartamenti) {
			String idGruppo= gruppoRepository.findIdGruppo(idAppartamento);
			String idSquadra= gruppoRepository.findIdSquadra(idGruppo);
			String idPrenotazione= interventoPuliziaRepository.findIdPrenotazione(idAppartamento);
			Optional<Prenotazione> p= prenotazioneRepository.findById(idPrenotazione);
			String idBox=idAppartamento+idSquadra+idPrenotazione;
			List<String> kitCatB= new ArrayList<String>();
			box.setId(idBox);
			box.setId_appartamento(idAppartamento);
			box.setId_prenotazione(idPrenotazione);
			box.setId_squadra(idSquadra);
			boxRepository.save(box);
			List<String> idKitCatB= kitAppartamentoRepository.findKitAppartamento(idAppartamento);
			List<String> kitCatD= kitRepository.findCategoriaD();
			if(p !=null) {
				int numNotti = calcolaNumeroGiorni(p.get().getDataCheckIn(), p.get().getDataCheckOut());
			}
				List<String> kitCatC=kitRepository.findCategoriaC(/*p.get().getNumOspiti(), numNotti*/);
			for(String idCatB: idKitCatB) {
				String idKitB= kitRepository.findCategoriaB(idCatB);
				kitCatB.add(idKitB);
			}
			for(String idKitB : kitCatB) {
				KitBox kitBox= new KitBox();
				kitBox.setId_box(idBox);
				kitBox.setId_kit(idKitB);
				kitBoxRepository.save(kitBox);
			}
			for(String idKitC : kitCatC) {
				KitBox kitBox= new KitBox();
				kitBox.setId_box(idBox);
				kitBox.setId_kit(idKitC);
				kitBoxRepository.save(kitBox);
			}
			for(String idKitD : kitCatD) {
				KitBox kitBox= new KitBox();
				kitBox.setId_box(idBox);
				kitBox.setId_kit(idKitD);
				kitBoxRepository.save(kitBox);
			}
			
		}
	}
	
	 private int calcolaNumeroGiorni(Date data1, Date data2) {
	      // Implementa la logica per calcolare il numero di giorni tra due date
	      
	  	 
	       Period period = Period.between(data1.toInstant()
	    		      .atZone(ZoneId.systemDefault())
	    		      .toLocalDate(), data2.toInstant()
	    		      .atZone(ZoneId.systemDefault())
	    		      .toLocalDate());
	       int days = Math.abs(period.getDays());
	       System.out.println(days);
	      return days;
	  }
}