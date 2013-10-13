package model;

import java.util.LinkedList;
import java.util.List;

public class Quiz {

	private int aantalDeelnames;
	private int leerjaar;
	private Leraar leraar;
	private String onderwerp;
	private QuizStatus quizStatus;
	private List<Opdracht> opdrachten = new LinkedList<Opdracht>();

	//test
	public Quiz() {
	}

	public int getAantalDeelnames() {
		return aantalDeelnames;
	}

	public void setAantalDeelnames(int aantalDeelnames) {
		this.aantalDeelnames = aantalDeelnames;
	}

	public int getLeerjaar() {
		return leerjaar;
	}

	public void setLeerjaar(int leerjaar) {
			this.leerjaar = leerjaar;
	}

	public Leraar getLeraar() {
		return leraar;
	}

	public void setLeraar(Leraar leraar) {
		this.leraar = leraar;
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public QuizStatus getQuizStatus() {
		return quizStatus;
	}

	public void setQuizStatus(QuizStatus quizStatus) {
		this.quizStatus = quizStatus;
	}

	public void addOpdracht(List<Opdracht> opdracht) {
		try {
			for (Opdracht o : opdracht) {
				opdrachten.add(o);
			}
		} catch (NullPointerException ex) {
			System.out.println(ex);
		}
	}
}
