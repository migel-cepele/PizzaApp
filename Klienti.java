package projektiPiceria;
/*Kjo klase sherben per te krijuar objektet e klienteve qe porosisin picat
 * permban funksionet per te vendosur te dhenat dhe per ti marre ato
 */

 public class Klienti{

    private String emri; //emri klientit
    private String mbiemri;
    private String adresa;
    private String nrTel;
    


    //konstruktor inicializon te dhenat e klientit
    public Klienti(String e, String m, String a, String nrTel) {

        setKlient(e,m, a, nrTel);

        
    }
    
  //funksion qe inicializon objektin klient
    private void setKlient(String e, String m, String a, String nrTel) {
    	
    	setEmri(e);
        setMbiemri(m);
        setAdresa(a);
        setNrTel(nrTel);
           
    }

    public Klienti getKlienti() {return this;} //kthen objektin e porosise

    private void setEmri(String e) {
        
        emri = e;

    }

    private void setMbiemri(String m) {
        mbiemri = m;
    }

    private void setAdresa(String a) {
        adresa = a;
    }

    private void setNrTel(String nt) {
        nrTel = nt; //dhe ketu duhet nje validim
    }

    //funksionet get
    public String getEmri() {return emri;}
    public String getMbiemri() {return mbiemri;}
    public String getAdresa() {return adresa;}
    public String getNrTel() {return nrTel;}
    
    //afishimi i te dhenave
    public String kthe_teDhena() {
    	return String.format("Emri: %s  Mbiemri: %s%nAdresa: %s%nNumri Telefonit: %s%n",
    			getEmri(), getMbiemri(), getAdresa(), getNrTel());
    	
    }

}
