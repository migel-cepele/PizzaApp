package projektiPiceria;
/*Kjo klase krijon objektin e pices se zgjedhur
 * me emrin, sasin dhe madhesine e saj
 * permban klasen enum qe ruan llojet e madhesise se pices*/

public class PicaPorositur {
	
	private String pica; //pica qe porositet
	private int numri; //numri i picave te porositura
	
	//enum qe mban llojet e ndryshme te madhesive te picave
    public enum MadhesiaPices {VOGEL, NORMALE, FAMILJARE};
    private MadhesiaPices madhesia;
    
    
    //konsturktori
    public PicaPorositur(String pica, int numri, int p) {
    	
    	setPica(pica, numri, p);
    }	
	
    //funksionet set
    public void setPica(String pica, int numri, int p) {
        this.pica = pica;
    	
    	if(numri <= 0)
    		throw new IllegalArgumentException("Numri i picave te porositura duhet me i madh se 0");
    	
    	this.numri = numri;
    	setMadhesia(p);
    }
    
	public void setMadhesia(int p) {
        
        if(p == 1)
        madhesia = MadhesiaPices.VOGEL;
        else if(p==2)
        madhesia = MadhesiaPices.NORMALE;
        else if(p==3)
        madhesia = MadhesiaPices.FAMILJARE;
        else
        throw new IllegalArgumentException("Argument i gabuar, duhet midis 1 dhe 3!");
    }
	
	//funksionet get
	public MadhesiaPices getMadhesia() {return madhesia;}
	
	public String getPicaPorositur() {return pica;}
	
	public int getNumri() {return numri;}
	
	
	 //kthen nje paraqitje ne string te objektit
	 public String ktheString() {
		 return String.format("Pica porositur: %s%nSasia: %d%n", getPicaPorositur(), getNumri());
	 }

}
