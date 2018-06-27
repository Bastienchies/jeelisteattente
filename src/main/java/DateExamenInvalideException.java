import java.time.LocalDate;

public class DateExamenInvalideException extends ExamenException {

	private static final long serialVersionUID = -3651453340454582365L;

	public DateExamenInvalideException(LocalDate date, String raison) {
		super(String.format("La date d'examen du %1$te %1$tB %1$tY est invalide : %2$s !", date, raison));
	}

}
