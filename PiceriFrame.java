package projektiPiceria;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*Klasa e vetme e pjeses View dhe Controller te GUI
 * Ketu jane ndertuar te gjithe komponentet e vendosur ne dritare
 * Gjithashtu po ketu jane menaxhuar dhe ngjarjet e secilit komponent
 * */

public class PiceriFrame extends JFrame{

	//objektet e klasave model
	private Klienti klienti; //klienti
	private String emriKlient;
	private String mbiemriKlient;
	private String adresa;
	private String numriTel;
	
	//piceria
	private Piceria piceria = new Piceria();
	
	//variabla ndihmese per te inicializuar objektet e klasave
	private String pica_Porositur;
	private int sasia_pices;
	private int madhesia_pices;
	
	private String pija_Porositur;
	private int sasia_Pijes;
	
	//emri picerise
	private JLabel emri;
	
	//lista e picave
	private JList<String> picat;
	
	
	//llojet e madhesise se picave
    private JRadioButton vogel;
    private JRadioButton normale;
    private JRadioButton familjare;
    private ButtonGroup grupi_madhesive;//grupi i radiobutonave te madhesise
    
    //textfield qe merr sasine e pices se zgjedhur
    private JTextField sasia_pice;
    
    //butonat per shtimin ose heqjen nga shporta te picave
    private JButton shto_pice;
    private JButton hiq_pice;
    
    //lista e pijeve
  	private JList<String> pijet;
  	
      
    //textfield qe merr sasine e pijes se zgjedhur
    private JTextField sasia_pije;
      
    //butonat per shtimin ose heqjen nga shporta te pijeve
    private JButton shto_pije;
    private JButton hiq_pije;
    
    //te dhenat e klientit
    private JTextField emri_klientit;
    private JTextField mbiemri_klientit;
    private JTextField adresa_klientit;
    private JTextField nrTel;
    
    //llojet e pagesave
    private JLabel lloji_pageses;
    private JRadioButton cash;
    private JRadioButton karte;
    private ButtonGroup grupi_pagesave;//grupi i radiobutonave te madhesise
    
    //buton per perfundimin e porosise
    private JButton perfundo;
    
    //Porosia e klientit e afishuar
    private JTextArea fatura;
    
    
	
	public PiceriFrame() { //konstruktori
		
        super("Pica Studenti");
        setLayout(new FlowLayout()); //perzgjedhja e layout
        getContentPane().setBackground(new Color(255, 225, 93)); //perzgjedhja e background
        
        
        //pjesa e emrit te picerise(reshti i pare ne dritare)
        //inicializimi i emrit te picerise
        emri = new JLabel("Pica Studenti", SwingConstants.LEFT);
        emri.setHorizontalAlignment(SwingConstants.CENTER);
        emri.setForeground(new Color(176, 30, 104));
        emri.setFont(new Font("Serif", Font.BOLD, 50));
        
        add(emri); //shtimi i komponentit ne kontenier
        
      //hapsire e nevojshme ne rreshtin e pare
        JLabel hapsire = new JLabel("                                                                                                      "+
        "                                                                                                                                  ");
        
        add(hapsire); 

        //pjesa e picave (rreshti i dyte ne dritare)
       //inicializimi i listes se picave
        
        JLabel l = new JLabel("Picat ");
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        l.setForeground(new Color(176, 30, 104));
        l.setFont(new Font("Serif", Font.BOLD, 25));
        add(l);
        
        picat = new JList<String>(piceria.getPicat());
        picat.setVisibleRowCount(5);
        
      //lejohet vetem nje selektim
        picat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //shtojme nje JScrollPane me JList per te naviguar ne liste
        add(new JScrollPane(picat));

        picat.addListSelectionListener(
            new ListSelectionListener() { //klase e brendshme anonime

                @Override
                public void valueChanged(ListSelectionEvent event) {
                    pica_Porositur = piceria.getPicat()[picat.getSelectedIndex()];
                }
                
            }
        );
		
		//zgjedhja e madhesise se pices
		vogel = new JRadioButton("vogel", false);
		normale = new JRadioButton("normale", false);
		familjare = new JRadioButton("familjare", false);
		add(vogel);
		add(normale);
		add(familjare);
		grupi_madhesive= new ButtonGroup(); //siguron qe te zgjidhet vetem njeri opsion
		grupi_madhesive.add(familjare);
		grupi_madhesive.add(normale);
		grupi_madhesive.add(vogel);
		
		
		//regjistrimi i ngjarjeve per radio butonat e madhesise
        vogel.addItemListener(new ItemListener() {
        	@Override
        	public void itemStateChanged(ItemEvent e) {
        		madhesia_pices = 1;
        	}
        });
        normale.addItemListener(new ItemListener() {
        	@Override
        	public void itemStateChanged(ItemEvent e) {
        		madhesia_pices = 2;
        	}
        });
        familjare.addItemListener(new ItemListener() {
        	@Override
        	public void itemStateChanged(ItemEvent e) {
        		madhesia_pices = 3;
        	}
        });
        
		
		
		//sasia e picave
		sasia_pice = new JTextField("Sasia", 5);
		add(sasia_pice);
		
		//menaxhimi i ngjares per sasine e pices
		sasia_pice.addActionListener(new ActionListener()
		{
			private String s = "";
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s = e.getActionCommand();
				sasia_pices = Integer.parseInt(s);
				
			}	
		});
		
		
		//inicializimi butonave
		shto_pice = new JButton("Shto ne shporte");
		hiq_pice = new JButton("Hiq nga shporta");
		add(shto_pice);
		add(hiq_pice);
		
		//menaxhimi i ngjarjeve per butonat se picave
		shto_pice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(piceria.getIndeksiPicave() < piceria.getShportaPicave().length) {
					piceria.shtoShportaPicave(new PicaPorositur(pica_Porositur, sasia_pices, madhesia_pices));
					JOptionPane.showMessageDialog(null,pica_Porositur +"  "+ sasia_pices + "  Opsioni i madhesise: " + madhesia_pices);
					
					sasia_pices = 0; //riinicializimi i variablave ne rast se klienti shton perseri ne shporte
					pica_Porositur = "";
					madhesia_pices = 0; 
      				
      			} else {
      				JOptionPane.showMessageDialog(null, "Nuk ka me vend ne shporten e picave!");
      				
      			}
				
			}
		});
		
        hiq_pice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(piceria.getIndeksiPicave() > 0) {
					piceria.hiqShportaPicave();
					JOptionPane.showMessageDialog(null, "Pica u hoq nga shporta!");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Shporta e picave eshte bosh!");
					
				}
				
			}
		});
		
		
		//pjesa per pijet
		//inicializimi i listes se pijeve
        
        JLabel l1 = new JLabel("Pijet ");
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setForeground(new Color(176, 30, 104));
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        add(l1);
        
        
        pijet = new JList<String>(piceria.getPijet());
        pijet.setVisibleRowCount(5);
        
      //lejohet vetem nje lloj selektimi
        picat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //shtojme nje JScrollPane me JList per te naviguar ne liste
        add(new JScrollPane(pijet));

        pijet.addListSelectionListener(
            new ListSelectionListener() { //klase e brendshme anonime

                @Override
                public void valueChanged(ListSelectionEvent event) {
                    pija_Porositur = piceria.getPijet()[pijet.getSelectedIndex()];
                }
                
            }
        );
        //hapsire bosh per rregullimin e komponenteve ne dritare
        JLabel hapsire2 = new JLabel("                                                                           " + 
        "             ");
        add(hapsire2);
        
        sasia_pije = new JTextField("sasia", 5); 
        add(sasia_pije);
        
      //menaxhimi i ngjares per sasine e pijes
      	sasia_pije.addActionListener(new ActionListener()
      	{
      		private String s = "";
      			
      		@Override
      		public void actionPerformed(ActionEvent e) {
      			s = e.getActionCommand();
      			sasia_Pijes = Integer.parseInt(s);
      				
      		}
      			
      	});
      		
        
      	//butonat e porosise se pijeve
        shto_pije = new JButton("Shto ne shporte");
        hiq_pije = new JButton("Hiq nga shporta");
        add(shto_pije);
        add(hiq_pije);
        
        //menaxhimi i ngjarjeve per butonat e pijeve
      	shto_pije.addActionListener(new ActionListener() {
      			
      		@Override
      		public void actionPerformed(ActionEvent e) {
      			
      			if(piceria.getIndeksiPijeve() < piceria.getShportaPijeve().length) {
      				
      				piceria.shtoShportaPijeve(new PijaPorositur(pija_Porositur, sasia_Pijes));
          			JOptionPane.showMessageDialog(null, pija_Porositur + " "+ sasia_Pijes );
          			pija_Porositur = "";
          			sasia_Pijes = 0;  
      				
      			} else {
      				JOptionPane.showMessageDialog(null, "Nuk ka me vend ne shporten e pijeve!");
      				
      			}
      	    }
      	});
      		
         hiq_pije.addActionListener(new ActionListener() {
      			
      		@Override
      		public void actionPerformed(ActionEvent e) {
      			
      			if(piceria.getIndeksiPijeve() > 0) {
      				piceria.hiqShportaPijeve();
          			JOptionPane.showMessageDialog(null, "Pija u hoq nga shporta!");
          			
				}
				else {
					JOptionPane.showMessageDialog(null, "Shporta e pijeve eshte bosh!");
					
				}
      			
      		}
      	});
        
        //inicializimi i te dhenave te klientit
        emri_klientit = new JTextField("Vendosni emrin", 10);
        mbiemri_klientit = new JTextField("Vendosni mbiemrin", 10);
        adresa_klientit = new JTextField("Vendosni adresen", 20);
        nrTel = new JTextField("Numri i telefonit", 10);
        add(emri_klientit);
        add(mbiemri_klientit);
        add(adresa_klientit);
        add(nrTel);
        

        //menaxhimi i ngjarjeve per te dhenat e klientit
        TeDhenaKlient handler = new TeDhenaKlient(); //klasa e brendshme qe menaxhon ngjarjet
        emri_klientit.addActionListener(handler);
        mbiemri_klientit.addActionListener(handler);
        adresa_klientit.addActionListener(handler);
        nrTel.addActionListener(handler);
      	
        
        //zgjedhja e menyres se pageses
        lloji_pageses = new JLabel("Zgjidhni llojin e pageses");
        lloji_pageses.setHorizontalAlignment(SwingConstants.CENTER);
        lloji_pageses.setForeground(new Color(176, 30, 104));
        lloji_pageses.setFont(new Font("Serif", Font.BOLD, 18));
        add(lloji_pageses);
        
        cash = new JRadioButton("Leke ne dore", false);
		karte = new JRadioButton("Karte Krediti", false);
		add(cash);
		add(karte);
		
		grupi_pagesave= new ButtonGroup(); //siguron qe te zgjidhet vetem njeri opsion
		grupi_pagesave.add(cash);
		grupi_pagesave.add(karte);
		
		//menaxhimi i ngjarjeve per radiobutonat e menyres se pageses
		cash.addItemListener(new ItemListener() {
        	@Override
        	public void itemStateChanged(ItemEvent e) {
        		piceria.setPagesa(1);
        	}
        });
        karte.addItemListener(new ItemListener() {
        	@Override
        	public void itemStateChanged(ItemEvent e) {
        		piceria.setPagesa(2);
        	}
        });
		
		
        JLabel hapsire3 = new JLabel("                                                                       ");
        add(hapsire3);
        
        //butoni per perfundimin e porosise
        perfundo = new JButton("Perfundo porosine");
        add(perfundo);
        
        //menaxhimi i ngjarjeve per butonin perfundo
        perfundo.addActionListener(new ActionListener() {
  			
      		@Override
      		public void actionPerformed(ActionEvent e) {
      			
      			fatura.setText(piceria.Fatura() + klienti.kthe_teDhena());
      			JOptionPane.showMessageDialog(null, piceria.Fatura());
      			
      		}
      	});
        
        //afishimi i porosise ne fund
        JLabel p = new JLabel("Porosia juaj");
        p.setHorizontalAlignment(SwingConstants.CENTER);
        p.setForeground(new Color(176, 30, 104));
        p.setFont(new Font("Serif", Font.BOLD, 20));
        
        fatura = new JTextArea(10,40);
        fatura.setEditable(false);
        add(p);
        add(fatura);
        
        	
	} //mbyllet konstruktori
	
	private class TeDhenaKlient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            

            //perdoruesi shtyp enter ne fushen e emrit
            if(event.getSource() == emri_klientit)
            emriKlient = String.format("%s", event.getActionCommand());

          //perdoruesi shtyp enter ne fushen e mbiemrit
            else if (event.getSource() == mbiemri_klientit)
            mbiemriKlient= String.format("%s", event.getActionCommand());

          //perdoruesi shtyp enter ne fushen e adreses
            else if(event.getSource() == adresa_klientit)
            adresa = String.format("%s", event.getActionCommand());

          //perdoruesi shtyp enter ne fushen e numrit te telefonit
            else if(event.getSource() == nrTel)
            numriTel = String.format("%s", event.getActionCommand());

          //inicializimi i te dhenave per klientin
          	klienti = new Klienti(emriKlient, mbiemriKlient, adresa, numriTel);


        }

    }



}


