package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LoopWedstrijd implements Iterable <Loper>{	
	private ArrayList <Loper> lopers;
	
	public LoopWedstrijd(){
		lopers = new ArrayList <Loper>();
	}
	
	public void voegLoperToe(String naam){
		Loper loper = new Loper(naam);
		lopers.add(loper);
	}
	
	public void setStartWedstrijd(Tijd start){
		for (Loper loper : lopers){
			loper.setStart(start);
		}
	}
	
	public void setAankomst (int nummer, Tijd aankomst){
		for (Loper loper : lopers){
			if (loper.getNummer()== nummer){
				loper.setAankomst(aankomst);
				break;
			}
		}
	}
	
	public String getIngeschrevenDeelnemers(){
		String terug ="";
		for (Loper loper : lopers){
			terug += loper.getNummer() + "  "+loper.getNaam()+ "\n";
		}
		return terug;
		
	}
	
	public String getAangekomenDeelnemers(){
		String terug ="";
		ArrayList <Loper> hulp = (ArrayList<Loper>)lopers.clone();
		Collections.sort(hulp);
		for (Loper loper : hulp){
			if (loper.getWedstrijdTijd()!=null){
				terug += loper.getNummer() + "  "+loper.getNaam()+"  "+loper.getWedstrijdTijd().getTijd()+"\n";
			}			
		}
		return terug;		
	}
	
	public static void main(String[] args) {
		LoopWedstrijd w = new LoopWedstrijd();
		w.voegLoperToe("Jan");
		w.voegLoperToe("Piet");
		w.voegLoperToe("Rik");
		w.voegLoperToe("Frans");
		w.setStartWedstrijd(new Tijd(14,0,0));
		w.setAankomst(1, new Tijd(14,23,12));
		w.setAankomst(3, new Tijd(14,24,18));
		w.setAankomst(4, new Tijd(14,21,42));
		System.out.println("Deelnemers:\n"+w.getIngeschrevenDeelnemers());
		System.out.println("Rangschikking:\n"+w.getAangekomenDeelnemers());
	}

	public Iterator<Loper> iterator() {
		return lopers.iterator();		
	}
}