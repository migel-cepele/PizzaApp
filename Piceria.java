package projektiPiceria;

import projektiPiceria.PicaPorositur.MadhesiaPices;
/*Klasa kryesore e aplikimit per pjesen e modelit
 * permban te dhenat e aplikimit
 * permban nje klase enum per llojet e pagesave
 * permban funksionet e llogaritjes se cmimit dhe printimit te fatures*/

public class Piceria {


    private final String picat[] = {"Margarita", "Proshute", "Peperoni", 
    "Proshute-Kerpudhe", "4-Djatherat", "4-Stinet", "Ton", "Ton-Kerpudhe", "Kapricoza", 
    "Vegjetariane"}; //vektor qe ruan picat standarde qe ka piceria
    
    //cmimet per secilen pice standarde bazuar ne madhesine e tyre korrensponduese
    private final int cmimetPicaVogla[] ={150, 200, 200, 200, 200, 250, 250, 250, 250, 200};
    private final int cmimetPicaNormale[] = {300, 350, 400, 400, 400, 400, 500, 500, 500, 400};
    private final int cmimetPicaFamiljare[] = {600, 750, 850, 800, 800, 800, 900, 950, 900, 800}; 
    
    
    //vektore qe permban pijet ne piceri
    private final String[] pijet = {"Coca-Cola", "Fanta", "Dhalle", "Birra", "Uje", "Asgje"};

    //vektore qe permban cmimet per cdo pije
    private final int[] cmimetPije = {150, 150, 50, 200, 50,0};

    private final int tarifaTransportit = 200; // mund ta leme dhe falas ne varesi te porosise
    //dhe mund te jete po ne varesi te porosise mund te mos dergojme fare


    private int cmimiTotal = 0; //cmimi i porosise se bashku me ate transportit
    
    
    private PicaPorositur[] shportaPicave = new PicaPorositur[30]; //objektet e picave te porositura. gjatesia e vektorit eshte 30
    //seose jane 30 lloje picash te ndryshme ne varesi te madhesise qe mund te porositen
    private int indeksiPicave = 0; //tregon indeksin e pices se fundit te porositur
    
    private PijaPorositur[] shportaPijeve = new PijaPorositur[6]; //objektet e pijeve te porositura
    private int indeksiPijeve = 0; //tregon indeksin e pijes se fundit te porositur

    //enum qe mban 2 llojet e pageses
    public enum LlojiPageses { KARTE_KREDITI, CASH};
    private LlojiPageses pagesa;
   
    
 
    public void shtoShportaPicave(PicaPorositur p) { //shtohet nje pice ne shporte
    	
    	shportaPicave[indeksiPicave++] = p;
    	
    	    	
    }
    
    public void hiqShportaPicave() { //hiqet nje pice nga shporta
    	shportaPicave[indeksiPicave] = null;
    	indeksiPicave--;
    }
    
    public void shtoShportaPijeve(PijaPorositur p) {
    	shportaPijeve[indeksiPijeve++] = p;
    }
    
    public void hiqShportaPijeve() {
    	shportaPijeve[indeksiPijeve] = null;
    	indeksiPijeve--;
    	
    }

    public int llogaritCmim() {  //funksion qe llogarit cmimin
    	
    	//llogaritja e cmimit per picat
    	for(int i = 0; i < indeksiPicave; i++) { //itenerim neper shporten e picave
    		
    		for(int j = 0; j < 10; j++) { //kerkojme per picen ne picat e Picerise
    			
    			if(picat[j].equals(shportaPicave[i].getPicaPorositur())) {
    				
    				if(shportaPicave[i].getMadhesia() == MadhesiaPices.VOGEL) {
    					
    					cmimiTotal+=cmimetPicaVogla[j] * shportaPicave[i].getNumri();
    					
    				} else if(shportaPicave[i].getMadhesia() == MadhesiaPices.NORMALE) {
    					
    					cmimiTotal+=cmimetPicaNormale[j] * shportaPicave[i].getNumri();
    					
    				} else {
    					
    					cmimiTotal+=cmimetPicaFamiljare[j] * shportaPicave[i].getNumri();
    				}
    				break;
    			}
    		}
    	}  	
      
    	//llogaritja e cmimit per pijet
    	for(int i = 0; i < indeksiPijeve; i++) {
    		
    		for(int j = 0; j < 6; j++) {
    			
    			if(pijet[j].equals(shportaPijeve[i].getPijaPorositur())) {
    				cmimiTotal+=cmimetPije[j] * shportaPijeve[i].getNumri();
    			}
    		}
    		
    	}
    	 
        if((cmimiTotal > 500) && (cmimiTotal < 2000))
            return cmimiTotal += tarifaTransportit; //per kete rang cmimi shtohet dhe tarifa e transportit
        
        else if(cmimiTotal < 500)
             return -1; //porosia nuk mund te dergohet per shkak te kostove
        
        else
        	return cmimiTotal; //nese porosia eshte mbi 2000 leke , transporti do te jete falas
    }
 
    
    
    //funksionet set

    public void setPagesa(int p) {

        if(p == 1)
        	pagesa = LlojiPageses.CASH;
        else if(p==2)
            pagesa = LlojiPageses.KARTE_KREDITI;
        else
        throw new IllegalArgumentException("Argument i gabuar, duhet te zgjidhni midis 1 ose 2!");

    }


    //funksionet get
    

    public PicaPorositur[] getShportaPicave() {return shportaPicave;}
    public PijaPorositur[] getShportaPijeve() {return shportaPijeve;}
    public int getIndeksiPicave() {return indeksiPicave;}
    public int getIndeksiPijeve() {return indeksiPijeve;}
    
    public String[] getPicat() {return picat;}
    public String[] getPijet() {return pijet;}
    
    public LlojiPageses getPagesa() { return pagesa; }

    

    public String Fatura(){ //kthen faturen e kompletuar te porosise
      
    	String s = "Porosia e kryer: \n";
    	for(int i = 0; i <= indeksiPicave; i++) {
    		
    		if(shportaPicave[i] != null) {
    			s+= shportaPicave[i].ktheString();   
    		}	
    	}
    	
    	for(int i = 0; i <= indeksiPijeve; i++) {
    		
    		if(shportaPijeve[i] != null) {
    			s+=shportaPijeve[i].ktheString();
    		}
    				
    	}
    	
    	//lloji i pageses
    	String pagesa;
    	if(getPagesa() == LlojiPageses.CASH)
    		pagesa = "Leke ne dore";
    	else
    		pagesa = "Karte krediti";
    	
    	
    	//percaktimi i dergimit apo jo te porosise
    	int cmimi = llogaritCmim();
    	if(cmimi < 0) {
    		 return String.format("Porosia nuk mund te kryhet per shkak te kostove te picerise!%n%s%n%n",
    				"Duhet qe vlera e porosise te jete me e madhe se 500 leke!");
    		
    	}
    	else {
    		return s += String.format("Cmimi: %d%nMenyra e pageses: %s%n", cmimi, pagesa);
    	}

    }





}

