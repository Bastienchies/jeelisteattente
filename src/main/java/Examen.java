import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="examen", schema = "exorm", catalog = "")

public abstract class Examen {
    @Id
    @Column(name = "examenID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "examenCode", nullable = false)
	private String code;
    @Basic
    @Column(name = "examenDate", nullable = false)
	private LocalDate date;
    @Basic
    @Column(name = "examenNomEtudiant", nullable = false)
    private String nomEtudiant;

	public abstract float getNote();

	public abstract String getAppreciation();

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public LocalDate getDate() {
		return date;
	}

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public void setDate(LocalDate date) throws DateExamenInvalideException {
		checkPeriodeScolaire(date);
		checkJourSemaine(date);
		this.date = date;
	}

	private void checkPeriodeScolaire(LocalDate date) throws DateExamenInvalideException {
		if (date.getMonth().getValue() > Month.JUNE.getValue() && date .getMonth().getValue() < Month.OCTOBER.getValue()) {
			String msg = String.format("un examen doit être compris entre octobre et juin");
			throw new DateExamenInvalideException(date, msg);
		}
	}

	private void checkJourSemaine(LocalDate date) throws DateExamenInvalideException {
		if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new DateExamenInvalideException(date, "un examen ne peut pas avoir lieu un samedi ou un dimanche");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%1$2.2f/20 à l'examen du %2$te %2$tB %2$tY", getNote(), getDate());
	}

}
