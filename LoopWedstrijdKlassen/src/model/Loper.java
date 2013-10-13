package model;
public class Loper implements Comparable<Loper>{

	private int nummer;
	private String naam;
	private Tijd start = null;
	private Tijd aankomst = null;
	
	private static int hoogsteNummer = 0;
	
	public Loper (String naam){
		nummer = ++ hoogsteNummer;
		this.naam = naam;
	}
	
	public Tijd getAankomst() {
		return aankomst;
	}

	public void setAankomst(Tijd aankomst) {
		if (start == null || aankomst.compareTo(start) < 0 ) throw new IllegalArgumentException ("...");
		this.aankomst = aankomst;
	}

	public Tijd getStart() {
		return start;
	}

	public void setStart(Tijd start) {
		this.start = start;
	}

	public String getNaam() {
		return naam;
	}
	
	public int getNummer(){
		return nummer;
	}
	
	public Tijd getWedstrijdTijd(){
		if (start == null || aankomst == null)
			return null;
		return aankomst.verschilInTijd(start);	
	}
	
	@Override
	public String toString(){
		return
			"Nummer: "+nummer+"\n"+
			"Naam  : "+naam+"\n"+
			(start!=null?"Start  :"+start+"\n":"")+
			(aankomst!=null?"Aankomst:"+aankomst:"");	
	}
	
	public int compareTo(Loper loper) {
		if (this.getStart()== null) return 1;
		if (this.getAankomst() == null) return 1;
		if (loper.getStart() == null) return -1;
		if (loper.getAankomst() == null) return -1;
		return this.getWedstrijdTijd().compareTo(loper.getWedstrijdTijd());
	}
	
	public static void main(String[] args) {
		Loper l1 = new Loper ("Jan");
		Loper l2 = new Loper ("Piet");
		l1.setStart(new Tijd(14,0,0));
		System.out.println(l1+"\n"+l2);		
	}
}
