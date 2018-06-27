import java.util.Comparator;

public class CodeExamenComparator implements Comparator<Examen>{

	@Override
	public int compare(Examen e1, Examen e2) {
		if (e1 == null || e1.getCode() == null) {
			return -1;
		}
		if (e2 == null || e2.getCode() == null) {
			return 1;
		}
		return e1.getCode().compareTo(e2.getCode());
	}

}
