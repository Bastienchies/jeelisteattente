import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

	public static void main(String[] args) {
		Diplome diplome = new Diplome();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exorm");
        EntityManager entityManager = emf.createEntityManager();

		try {
			Controle controle = new Controle();
			controle.setNote(12);
			controle.setDate(LocalDate.now());
			controle.setNomEtudiant("DOE");

			Qcm qcm = new Qcm(30);
			qcm.setResponsesCorrecte(22);
			qcm.setDate(LocalDate.now().plusWeeks(1));
			controle.setNomEtudiant("DOE");

			Projet projet = new Projet();
			projet.setNote(2, 9);
			projet.setAppreciationOral("ne s'exprime pas clairement");
			projet.setAppreciationEcrit("très bon travail");
			projet.setDate(LocalDate.now().plusWeeks(2));

			diplome.setExamens(controle, projet, qcm);
			
			diplome.afficherNotes();
			diplome.afficherDetailDesNotes();
			if (diplome.isValide()) {
				System.out.format("Bravo, vous avez obtenu votre diplôme avec la mention %s !\n", diplome.getMention());
			} else {
				System.out.println("Vous n'avez pas obtenu votre diplôme !");
			}
		} catch (ExamenException e) {
			e.printStackTrace();
		}
	}
}
