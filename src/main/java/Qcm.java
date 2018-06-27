public class Qcm extends Examen {
	
	private int nbQuestions;
	private int nbReponsesCorrectes;

	public Qcm(int nbQuestions) throws NombreQuestionInvalideException {
		if (nbQuestions <= 0) {
			throw new NombreQuestionInvalideException();
		}
		this.nbQuestions = nbQuestions;
	}
	
	public void setResponsesCorrecte(int reponse) throws NoteInvalideException, NombreReponsesIncorrectException {
		if (reponse < 0 || reponse > nbQuestions) {
			throw new NombreReponsesIncorrectException(reponse, nbQuestions);
		}
		this.nbReponsesCorrectes = reponse;
	}
	
	@Override
	public float getNote() {
		return nbReponsesCorrectes / (float) nbQuestions * 20;
	}
	
	@Override
	public String getAppreciation() {
		if (this.getNote() < 8) {
			return "insuffisant";
		}
		if (this.getNote() < 12) {
			return "passable";
		}
		if (this.getNote() < 16) {
			return "bien";
		}
		return "très bien";
	}

}
