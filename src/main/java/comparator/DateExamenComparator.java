import java.util.Comparator;

public class DateExamenComparator implements Comparator<Examen>{

	@Override
	public int compare(Examen e1, Examen e2) {
		if (e1 == null || e1.getDate() == null) {
			return -1;
		}
		if (e2 == null || e2.getDate() == null) {
			return 1;
		}
		return e1.getDate().compareTo(e2.getDate());
	}

}
