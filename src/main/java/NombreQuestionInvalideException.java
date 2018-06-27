public class NombreQuestionInvalideException extends QcmException{

	private static final long serialVersionUID = 5341670450549040712L;

	public NombreQuestionInvalideException() {
		super("Le nombre de question doit être strictement positif !");
	}

}
