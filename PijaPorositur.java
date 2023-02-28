package projektiPiceria;
/*klase qe sherben per inicializimin e objektit te pijes se zgjedhur
 * me emrin dhe sasine e zgjedhur te saj*/

public class PijaPorositur {
	
	private String pija; //pija e porositur
	int numri; //sa eshte numri i pijes se porositur
	
	//konstruktori
	public PijaPorositur(String pija, int numri) {
		setPija(pija, numri);
	}
	
	//funksioni set
	private void setPija(String pija, int numri) {
        this.pija = pija;
    	
    	if(numri <= 0)
    		throw new IllegalArgumentException("Numri i pijeve te porositura duhet me i madh se 0");
    	
    	this.numri = numri;
	}
	
	//funksionet get
	 
	 public String getPijaPorositur() {return pija;}
	 
	 public int getNumri() {return numri;}
	 
	 //kthen nje paraqitje ne string te objektit
	 public String ktheString() {
		 return String.format("Pija porositur: %s%nSasia: %d%n", getPijaPorositur(), getNumri());
	 }

}
