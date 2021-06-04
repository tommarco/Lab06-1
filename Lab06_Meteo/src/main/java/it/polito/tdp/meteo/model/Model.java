package it.polito.tdp.meteo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.meteo.DAO.MeteoDAO;


public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	
	MeteoDAO meteoDao;
	private List<Citta> partenza;
	private List <Citta> soluzioneMigliore;//attributo che verrà
	//usata quando troveremo delle soluzioni più buone di quelle che abbiamo visto
	private double minimoCosto;

	public Model() {
		
		
		meteoDao= new MeteoDAO();
		
		partenza=meteoDao.getAllCitta();
		


	}   
	
public List <Citta> calcolaSottoinsiemeCitta(int mese) {
	List<Citta> parziale = new ArrayList<Citta>();
	soluzioneMigliore= new ArrayList<Citta>();
	minimoCosto=0;
	
	//MA PER TENERE IL CONTO DEI NUMERO DEI GIORNI CHE SONO CONSECUTIVI O NON????
	sequenza(parziale,0);
	
	return soluzioneMigliore;	
}


private void sequenza(List<Citta> parziale, int L ) {
	//casi terminali
	
	//A CONDIZIONI DI TERMINAZIONE
	//
	if(L==partenza.size()) {
		double costo= calcolaCostoMinimo(parziale);
	
		if(costo<minimoCosto){
	
			soluzioneMigliore= new ArrayList <>(parziale); //LinkedList
			
			minimoCosto= costo;
			
			return;
		}
	
	}
	
//	1) NEI PRIMI 15 GIORNI DEL MESE  UNA CITTA DEVE ESSERE VISITATA UNA VOLTA
//	 *QUINDI DOVREI SEGNARE UN COUNTER ALMENO PARI A UNO
	
	
	
	


//generare i sotto-problemi
// PARTENZA[L] è da aggiungere oppure no? Provo entrambe le cose
	
/*	//IF(FILTRO) //C
	 *
	
	 *2) IL TECNICO NON SI PUO' SPOSTARE PRIMA DI AVER TRASCORSO 3 GIORNI CONSECUTIVI
	 *
	 *
	parziale.add(partenza.get(L);
	cerca2(parziale, L+1, NUMERO_GIORNI_CITTA_MAX, NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN);
	
	*/
	//SE TROVO UNA CITTA  DEVO DECIDERE QUALE CITTA ANDARE PROVO AD AGGIUNGERE SE RISPETTA I VINCOLI ALLORA AGGIUNGO E PO
	//TOLGO
	
	//DA RIVEDERE
	
	for(Citta c: parziale) {
		
		if(c.getNumeroGiorni()<3) {
			
			 c.incrementaGiorni();
		
			
		}
		
		if(c.getNumeroGiorni()==3) {
			
			c.increaseCounter();
			
			parziale.add(partenza.get(L));
			sequenza(parziale, L+1);
		}
		
		if(c.getNumeroGiorni()) {
		
		
		
	}
	
	//BACKTRACKING D
	
	
	
	
			
		
		
	

	
	
	
}

public double calcolaCostoMinimo(List<Citta> citta) {
	
	double minimoCosto=0;
	
	for(Citta c : citta){
		
		for(Rilevamento r: c.getRilevamenti()) {
			
			//se il tecnico si sposta in 2 giorni successivi
			//uso un fattore moltiplicativo
	
			if(c.getCounter()==2) {
			
				minimoCosto+=COST+ r.getUmidita();
					
			}
		}
		
	}	
	
	return minimoCosto;
}



	// of course you can change the String output with what you think works best

	public double mediaUmidita(int mese){
		
		return meteoDao.mediaUmidita(mese);
		
	}
	public String getUmiditaMedia(int mese) {
		return "TODO!";
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	

}
