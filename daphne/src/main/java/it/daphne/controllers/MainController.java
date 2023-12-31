package it.daphne.controllers;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.daphne.entity.CalendarioPulizia;
import it.daphne.entity.InterventoPulizia;
import it.daphne.entity.Prenotazione;
import it.daphne.repository.AppartamentoRepository;
import it.daphne.repository.InterventoPuliziaRepository;
import it.daphne.repository.PrenotazioneRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/prenotazione") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private PrenotazioneRepository prenotazioneRepository;
  
    @Autowired
    private InterventoPuliziaRepository interventoPuliziaRepository;
    
    @Autowired
    private AppartamentoRepository appartamentoRepository;

    
   
   @PostMapping(path="/search") // Map ONLY POST Requests
   public @ResponseBody String cercaPrenotazione (@RequestParam Date check_in
    	      , @RequestParam Date check_out, @RequestParam int num_ospiti) throws Exception {
  	List<String> listAppartamentiDaControllare=new ArrayList<>();
  	List<String> listAppartamentiDisponibili=new ArrayList<>();
  	List<String> idAppartamenti= appartamentoRepository.findAllId();
  	for(String id : idAppartamenti) {
  		if(verificaInserimentoPrenotazione(new Prenotazione("test",id,check_in,check_out,num_ospiti))) {
  		listAppartamentiDaControllare.add(id);	
  		};
  		
  	}
  	
  	for(String id: listAppartamentiDisponibili) {
  		verificaInterventoPulizia(id, num_ospiti, new Prenotazione("test",id,check_in,check_out,num_ospiti));
  		listAppartamentiDisponibili.add(id);
  	}
  	System.out.println("APPARTAMENTI DISPONIBILI:");
  	for(String id: listAppartamentiDisponibili) {
  		System.out.println(id);
  	}
  	return "OK";
  	  
   }
   
   
  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewPrenotazione (@RequestParam Date check_in
      , @RequestParam Date check_out,
      @RequestParam String id_appartamento,
      @RequestParam int num_ospiti) throws Exception {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  
    Prenotazione p = new Prenotazione();
    p.setDataCheckIn(check_in);
    p.setDataCheckOut(check_out);
    p.setIdAppartamento(id_appartamento);
    p.setNumOspiti(num_ospiti);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //verificare se prenotazione si puo inserire(casa occupata o no)
    String checkOutPrec = trovaPrenotazionePrecedente(p);
    String idSucc= trovaPrenotazioneSuccessiva(p);
    eliminaInterventiPrenotazioneSucc(idSucc, p);
    Boolean b=verificaInserimentoPrenotazione(p);
    if(!b) {
    	throw new Exception("Impossibile: casa già occupata");
    }

    int giorniDispPerLavare= calcolaNumeroGiorni(p.getDataCheckIn(), dateFormat.parse(checkOutPrec));
    inserisciInterventoPulizia(checkOutPrec, giorniDispPerLavare, p);

    return "Saved";
  }
  

  @PostMapping(path="/removeInterventiOggi") // Map ONLY POST Requests
  public @ResponseBody String removeInterventiOggi () throws Exception {
	interventoPuliziaRepository.setEliminatollInterventiPuliziaDelGiorno();
	List<String> idEliminati= interventoPuliziaRepository.findAllInverventiEliminati();
	for(String id: idEliminati) {
	interventoPuliziaRepository.deleteAllInterventiPuliziaEliminati(id);
	};
	return "OK";
	  
  }
  
  @PostMapping(path="/ricalcolaInterventi") // Map ONLY POST Requests
  public @ResponseBody String ricalcolaInterventi () throws Exception {
	List<Prenotazione> listPrenotazione= prenotazioneRepository.findPrenotazioniDopoOggi();
	interventoPuliziaRepository.deleteAllInterventiPuliziaDopoOggi();
	for(Prenotazione p: listPrenotazione) {
		addNewPrenotazione(p.getDataCheckIn(),p.getDataCheckOut(),p.getIdAppartamento(),p.getNumOspiti());
	}
	return "OK";
	  
  }
	  
  
  private Boolean verificaInserimentoPrenotazione(Prenotazione prenotazione) throws ParseException {
	  String idApp= prenotazione.getIdAppartamento();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

      List<Prenotazione> prenotazioniApp= prenotazioneRepository.getByIdAppartamento(idApp);
      String dataCheckOutPrec= getDataOggi();
      if(!( Objects.isNull(prenotazioniApp) || prenotazioniApp.isEmpty() )) {
    	 
      	dataCheckOutPrec=  dateFormat.format(prenotazioniApp.get(prenotazioniApp.size()-1).getDataCheckOut());
      	
      	for(Prenotazione p: prenotazioniApp) {
      		if(prenotazione.getDataCheckIn().after(calcolaDataPrecedente(p.getDataCheckIn())) && prenotazione.getDataCheckIn().before(p.getDataCheckOut()) || prenotazione.getDataCheckOut().after(p.getDataCheckIn()) && prenotazione.getDataCheckOut().before(p.getDataCheckOut()) ) {
      			return false;
      		}
      		if(prenotazione.getDataCheckIn().before(p.getDataCheckIn()) && prenotazione.getDataCheckOut().after(calcolaDataPrecedente(p.getDataCheckOut()))) {
      			return false;
      		}

      	}
      	
      }
	  
	  return true;
  }
  
  private void eliminaInterventiPrenotazioneSucc(String idSucc,Prenotazione p) throws Exception {
	  if(idSucc != "-1") {
		    List<Date> dateIdSucc= interventoPuliziaRepository.findAllInverventiFromId(idSucc);
		    Boolean trovataDataSuccessiva= false;
		    for(Date d: dateIdSucc) {
		    	if(d.after(calcolaDataPrecedente(p.getDataCheckOut()))) {
		    		trovataDataSuccessiva=true;
		    	}
		    }
		    	if(trovataDataSuccessiva) {
		    		for(Date d: dateIdSucc) {
		    			if(d.before(p.getDataCheckOut())){
		    				interventoPuliziaRepository.deleteIntervento(idSucc, d);
		    			}
		    		}
		    	} else {
		    		throw new Exception("Impossibile inserire prenotazione: Impossibile eliminare interventi Pulizia");
		    	}
		    }
  }
 
  private String trovaPrenotazioneSuccessiva(Prenotazione prenotazione) throws ParseException {
	  String idApp= prenotazione.getIdAppartamento();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String idSucc = null;
      List<Prenotazione> prenotazioniApp= prenotazioneRepository.getByIdAppartamento(idApp);
      String dataCheckOutPrec= getDataOggi();
      if(!( Objects.isNull(prenotazioniApp) || prenotazioniApp.isEmpty() )) {
    	 Collections.sort(prenotazioniApp);
      	
      	for(int i=0;i<prenotazioniApp.size();i++) {
      	
	
	      	Date dateCheckIn=new Date();
			dateCheckIn = prenotazioniApp.get(i).getDataCheckIn();
	      	Date dateCheckOut= new Date();
			dateCheckOut = prenotazione.getDataCheckOut();
			
	      	if(dateCheckIn.after(calcolaDataPrecedente(dateCheckOut))) {
	               idSucc = prenotazioniApp.get(i).getId();
	      	}
      	 }
      }
      if(idSucc != null)
      return idSucc;
      else
      return "-1";
  }
    
  private String trovaPrenotazionePrecedente(Prenotazione prenotazione) throws ParseException {
	     

      String idApp= prenotazione.getIdAppartamento();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

      List<Prenotazione> prenotazioniApp= prenotazioneRepository.getByIdAppartamento(idApp);
      String dataCheckOutPrec= getDataOggi();
      if(!( Objects.isNull(prenotazioniApp) || prenotazioniApp.isEmpty() )) {
    	 Collections.sort(prenotazioniApp);
      	dataCheckOutPrec=  dateFormat.format(prenotazioniApp.get(prenotazioniApp.size()-1).getDataCheckOut());
      	
      	for(int i=0;i<prenotazioniApp.size();i++) {
      	
	
	      	Date dateCheckIn=new Date();
			dateCheckIn = prenotazioniApp.get(i).getDataCheckIn();
	      	Date dateCheckOut= new Date();
			dateCheckOut = prenotazione.getDataCheckOut();
			
	      	if(dateCheckIn.after(dateCheckOut) && i != 0) {
	              dataCheckOutPrec = dateFormat.format(prenotazioniApp.get(i-1).getDataCheckOut());
	      	}
      	}
      	
      }
      
      Date dateCheckOutPrec1= dateFormat.parse(dataCheckOutPrec);
      
      if(prenotazioniApp.size()==1) {
          dateCheckOutPrec1=prenotazioniApp.get(0).getDataCheckOut()	;
          }
      
      Date oggi= dateFormat.parse(getDataOggi());
      if(dateCheckOutPrec1.after(prenotazione.getDataCheckIn())) {
    	  return getDataOggi();
      }
      if(dateCheckOutPrec1.before(oggi))
      return getDataOggi();
      else {
      	return dataCheckOutPrec;
      }
  }
  
  private Boolean verificaInterventoPulizia(String checkOutPrec,int giorniDisponibili, Prenotazione prenotazione) throws Exception {
	  	int slotTotali=3;
	    Boolean slotOccupati= true;
	    String dataSlot=checkOutPrec; //partendo da quella data, poi andremo avanti fino a che si puo per vedere se si puo inserire
	    Boolean inserimentoPossibile=false;
	    int numVolteInserito=1;
	    prenotazione.setId(getRandomString(5));
	    List<InterventoPulizia> calendarioPulizie= new ArrayList<>();
	    String idWarehouse= appartamentoRepository.findWarehouse(prenotazione.getIdAppartamento());
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String codiceIntervento = getRandomString(5);	
  	for(int i=0;i<=giorniDisponibili;i++) {
  		calendarioPulizie= interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(checkOutPrec),idWarehouse);
  			    
	    		if(getSlotOccupati(checkOutPrec,prenotazione) < slotTotali) {
	    			calendarioPulizie.add( new InterventoPulizia(codiceIntervento, prenotazione.getId(),
		                    prenotazione.getIdAppartamento(), dateFormat.parse(checkOutPrec),numVolteInserito,false));
	    			slotOccupati=false;
	    			numVolteInserito++;
	    			System.out.println("ID:" + prenotazione.getId());
	    			inserimentoPossibile=true;
	    			break;
	    		}
	    
	    	
	    	
	    	try {
				checkOutPrec=calcolaDataSuccessiva(checkOutPrec);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }

  	if(slotOccupati==true) {
  		inserimentoPossibile=fakeLiberaSlot(dataSlot,dateFormat.format(prenotazione.getDataCheckIn()),prenotazione);
  	}

  	return inserimentoPossibile;
  }
 
  private void inserisciInterventoPulizia(String checkOutPrec,int giorniDisponibili, Prenotazione prenotazione) throws ParseException {
	  	int slotTotali=3;
	    Boolean slotOccupati= true;
	    String dataSlot=checkOutPrec; //partendo da quella data, poi andremo avanti fino a che si puo per vedere se si puo inserire

	    int numVolteInserito=1;
	    prenotazione.setId(getRandomString(5));
	    List<InterventoPulizia> calendarioPulizie= new ArrayList<>();
	    String idWarehouse= appartamentoRepository.findWarehouse(prenotazione.getIdAppartamento());
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String codiceIntervento = getRandomString(5);	
  	for(int i=0;i<=giorniDisponibili;i++) {
  		calendarioPulizie= interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(checkOutPrec),idWarehouse);
  			    
	    		if(getSlotOccupati(checkOutPrec,prenotazione) < slotTotali) {
	    			calendarioPulizie.add( new InterventoPulizia(codiceIntervento, prenotazione.getId(),
		                    prenotazione.getIdAppartamento(), dateFormat.parse(checkOutPrec),numVolteInserito,false));
	    			slotOccupati=false;
	    			numVolteInserito++;
	    			System.out.println("ID:" + prenotazione.getId());
	    			interventoPuliziaRepository.save(new InterventoPulizia(codiceIntervento, prenotazione.getIdAppartamento(),prenotazione.getId(),
		                  dateFormat.parse(checkOutPrec),numVolteInserito,false));
	    		
	    		}
	    
	    	
	    	
	    	try {
				checkOutPrec=calcolaDataSuccessiva(checkOutPrec);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    }

  	if(slotOccupati==true) {
  		liberaSlot(dataSlot,dateFormat.format(prenotazione.getDataCheckIn()),prenotazione);
  	}

	 prenotazioneRepository.save(prenotazione);
  }
  
  static String getRandomString(int i) 
  {
  
      // bind the length 
		 byte[] bytearray;
      bytearray = new byte[256];        
      String mystring;
      StringBuffer thebuffer;
      String theAlphaNumericS;

      new Random().nextBytes(bytearray); 

      mystring 
          = new String(bytearray, Charset.forName("UTF-8")); 
          
      thebuffer = new StringBuffer();
      
      //remove all spacial char 
      theAlphaNumericS 
          = mystring 
              .replaceAll("[^A-Z0-9]", ""); 

      //random selection
      for (int m = 0; m < theAlphaNumericS.length(); m++) {

          if (Character.isLetter(theAlphaNumericS.charAt(m)) 
                  && (i > 0) 
              || Character.isDigit(theAlphaNumericS.charAt(m)) 
                  && (i > 0)) {

              thebuffer.append(theAlphaNumericS.charAt(m)); 
              i--; 
          } 
      } 

      // the resulting string 
      return thebuffer.toString(); 
  } 

  private String getDataOggi() {
      // Implementa la logica per ottenere la data di oggi
      // Questo metodo dipende dalla tua implementazione delle date nel progetto
  	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();        
		String dateToStr = dateFormat.format(date);
		System.out.println("Date is "+ dateToStr);
      return dateToStr;
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
  
  private int getSlotOccupati(String data,Prenotazione p) {
      int slotOccupati = 0;
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      List<InterventoPulizia> interventiGiorno= new ArrayList<InterventoPulizia>();
      String idWarehouse= appartamentoRepository.findWarehouse(p.getIdAppartamento());
	try {
		interventiGiorno = interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(data),idWarehouse);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      for (InterventoPulizia intervento : interventiGiorno) {
          slotOccupati++;
      }
      return slotOccupati;
  }

  private String calcolaDataSuccessiva(String data) throws ParseException {
      // Implementa la logica per calcolare la data successiva data una data e un numero di giorni
      // Questo metodo dipende dalla tua implementazione delle date nel progetto
  	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  	Date date = dateFormat.parse(data);
  	LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
      Date currentDatePlusOneDay = Date.from(localDateTime.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
      String dateToStr = dateFormat.format(currentDatePlusOneDay);
		System.out.println("Date is "+ dateToStr);
      return dateToStr;
  }
  
  private Date calcolaDataPrecedente(Date date) throws ParseException {
      // Implementa la logica per calcolare la data successiva data una data e un numero di giorni
      // Questo metodo dipende dalla tua implementazione delle date nel progetto
  	
  	LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
      Date currentDateMinusOneDay = Date.from(localDateTime.minusDays(1).atZone(ZoneId.systemDefault()).toInstant());
     // String dateToStr = dateFormat.format(currentDateMinusOneDay);
		//System.out.println("Date is "+ dateToStr);
      return currentDateMinusOneDay;
  }

  
  private Boolean fakeLiberaSlot(String dataInizio,String dataFine,Prenotazione p) throws Exception {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  	String checkInPrec= dataInizio;
  	String idWarehouse= appartamentoRepository.findWarehouse(p.getIdAppartamento());
  	List<InterventoPulizia> interventiGiorno = interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(dataInizio),idWarehouse);
 	  InterventoPulizia interventoMax= interventiGiorno.get(0);
  	do {
  	  interventiGiorno = interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(dataInizio),idWarehouse);
  	  for (InterventoPulizia intervento : interventiGiorno) {
  	

  	    	Date dateIntervento=intervento.getData();
	
  	    	Date dateMax= interventoMax.getData();
			
        		if(intervento.getNumVolteInserito()>=interventoMax.getNumVolteInserito()/*&& (dateIntervento.compareTo(dateMax)==0 || dateIntervento.compareTo(dateMax)>0)*/ ) {
        		interventoMax=intervento;
        	}
  	  }
  	  try {
			dataInizio=calcolaDataSuccessiva(dataInizio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	} while(!dataInizio.equals(dataFine));
  	
  	if(interventoMax.getNumVolteInserito()>1) {
  		return true;
  	}	else {
  		return false;
  	}
  }
  private void liberaSlot(String dataInizio,String dataFine,Prenotazione p) throws ParseException {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  	String checkInPrec= dataInizio;
  	String idWarehouse= appartamentoRepository.findWarehouse(p.getIdAppartamento());
  	List<InterventoPulizia> interventiGiorno = interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(dataInizio),idWarehouse);
 	  InterventoPulizia interventoMax= interventiGiorno.get(0);
  	do {
  	  interventiGiorno = interventoPuliziaRepository.findAllInterventiPulizia(dateFormat.parse(dataInizio),idWarehouse);
  	  for (InterventoPulizia intervento : interventiGiorno) {
  	

  	    	Date dateIntervento=intervento.getData();
	
  	    	Date dateMax= interventoMax.getData();
			
        		if(intervento.getNumVolteInserito()>=interventoMax.getNumVolteInserito()/*&& (dateIntervento.compareTo(dateMax)==0 || dateIntervento.compareTo(dateMax)>0)*/ ) {
        		interventoMax=intervento;
        	}
  	  }
  	  try {
			dataInizio=calcolaDataSuccessiva(dataInizio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	} while(!dataInizio.equals(dataFine));
  	
  	if(interventoMax.getNumVolteInserito()>1) {
  	interventoPuliziaRepository.deleteIntervento(interventoMax.getIdAppartamento(),interventoMax.getData());
  	inserisciInterventoPulizia(dateFormat.format(interventoMax.getData()), 0, p);
  	}	else {
  		System.out.println("IMPOSSIBILE INSERIRE L'INTERVENTO");
  	}
  }
  

    

}