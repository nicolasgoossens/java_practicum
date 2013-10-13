package model;

public class Tijd implements Comparable<Tijd>{

	private int uur;
	private int minuut;
	private int seconde;
	
	public Tijd (int uur,int minuut,int seconde)throws IllegalArgumentException{
		setUur(uur);
		setMinuut(minuut);
		setSeconde(seconde);
	}
	
	public Tijd (int seconden)throws IllegalArgumentException{
		if (seconden < 0 || seconden > 3600*24)throw new IllegalArgumentException ("...");
		setUur(seconden/3600);
		setMinuut(seconden%3600/60);
		setSeconde(seconden%3600%60);
		
	}

	public int getMinuut() {
		return minuut;
	}

	public void setMinuut(int minuut) {
		this.minuut = minuut;
	}

	public int getSeconde() {
		return seconde;
	}

	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}

	public int getUur() {
		return uur;
	}

	public void setUur(int uur) throws IllegalArgumentException{
		if (uur < 0 || uur > 23)throw new IllegalArgumentException("Uur verkeerd!!!");
		this.uur = uur;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + minuut;
		result = PRIME * result + seconde;
		result = PRIME * result + uur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Tijd other = (Tijd) obj;
		if (minuut != other.minuut)
			return false;
		if (seconde != other.seconde)
			return false;
		if (uur != other.uur)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return String.format("%d:%02d:%02d %s",
				((uur == 0 || uur == 12)?12:uur % 12),minuut,seconde,(uur < 12? "AM":"PM"));
	}
	
	public String getTijd(){
		return String.format("%d uur %02d minuten %02d seconden",
				uur ,minuut,seconde);
	}
	
	public int getTijdInSeconden(){
		return uur * 3600 + minuut * 60 + seconde;
	}
	
	public Tijd verschilInTijd (Tijd tijd){
		int seconden = Math.abs(this.getTijdInSeconden() - tijd.getTijdInSeconden());
		return new Tijd(seconden);
	}
	
	public Tijd verhoog (Tijd tijd){
		int seconden = this.getTijdInSeconden() + tijd.getTijdInSeconden();
		// indien hoger dan maximum aantal seconden -> seconden aanpassen
		return new Tijd(seconden);
	}
	
	public Tijd verhoog (int seconden){
		int secondenh = this.getTijdInSeconden() + seconden;
		// indien hoger dan maximum aantal seconden -> seconden aanpassen
		return new Tijd(secondenh);
	}
	
	public int compareTo(Tijd tijd){
		return this.getTijdInSeconden() - tijd.getTijdInSeconden();
	}

	public static void main(String[] args) {
		try 
		{
			Tijd t1 = new Tijd (14,20,5);
			System.out.println(t1);
			Tijd t2 = new Tijd(3675);
			System.out.println(t2);
			System.out.println(t1.verschilInTijd(t2).getTijd());
		}
		catch (IllegalArgumentException ex){System.out.println(ex.getMessage());}
	}
}
