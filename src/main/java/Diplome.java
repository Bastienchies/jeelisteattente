import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Diplome {

	private List<Examen> examens = new ArrayList<>();

	public void setExamens(Examen... examens) {
		this.examens = new ArrayList<>();
		this.examens.addAll(Arrays.asList(examens));
	}
	
	public List<Examen> getExamens() {
		return examens;
	}

	public void addExamen(Examen examen) {
		examens.add(examen);
	}
	
	public List<Examen> getExamensAvecNoteInferieureA(float note) {
		List<Examen> resultat = new ArrayList<>();
		for (Examen examen : this.examens) {
			if (examen.getNote() < note) {
				resultat.add(examen);
			}
		}
		return resultat;
	}
	
	public void removeExamenAvecCode(String code) {
		Iterator<Examen> it = this.examens.iterator();
		while(it.hasNext()) {
			if (code.equals(it.next().getCode())) {
				it.remove();
			}
		}
	}

	public boolean isValide() {
		return getMoyenne() >= 10;
	}

	private float getMoyenne() {
		float total = 0;
		for (Examen examen : examens) {
			total += examen.getNote();
		}
		float moyenne = total / examens.size();
		return moyenne;
	}
	
	public void delivrer() throws DiplomeException {
		if (getMoyenne() < 10) {
			throw new DiplomeException("Le diplome ne peut pas être délivré !");
		}
	}
	
	public Mention getMention() {
		return Mention.fromNote(this.getMoyenne());
	}
	
	public Examen[] getExamens(Comparator<Examen> comparable) {
		Examen[] resultat = this.examens.toArray(new Examen[this.examens.size()]);
		Arrays.sort(resultat, comparable);
		return resultat;
	}
	
	public void afficherNotes() {
		for (Examen e : examens) {
			System.out.println(e);
		}
	}

	public void afficherDetailDesNotes() {
		for (Examen e : examens) {
			System.out.format("%2.2f - %s\n", e.getNote(),
					Objects.toString(e.getAppreciation(), "Aucune appréciation"));
		}
	}
}
