public class NombreReponsesIncorrectException extends QcmException{

	private static final long serialVersionUID = 5341670450549040712L;

	public NombreReponsesIncorrectException(int nbReponse, int maxReponse) {
		super(String.format("Le nombre de bonnes réponses doit être compris entre 0 et %2$d (reçu %1$d)", nbReponse, maxReponse));
	}

}
