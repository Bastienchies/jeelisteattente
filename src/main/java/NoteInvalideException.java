public class NoteInvalideException extends ExamenException {
	
	private static final long serialVersionUID = 8129484916024019644L;

	public NoteInvalideException(float note, float maxNote) {
		super(String.format("La note %1$.2f est invalide ! Une note doit être comprise entre 0 et %2$.2f", note, maxNote));
	}

}
