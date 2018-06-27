import java.util.Comparator;


public class NoteExamenComparator implements Comparator<Examen>{

	@Override
	public int compare(Examen e1, Examen e2) {
		if (e1 == null) {
			return -1;
		}
		if (e2 == null) {
			return 1;
		}
		return Float.compare(e1.getNote(), e2.getNote());
	}

}
