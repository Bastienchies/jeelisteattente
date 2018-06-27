public enum Mention {
	
	PASSABLE, BIEN, TRES_BIEN, EXCELLENT;
	
	public static Mention fromNote(float note) {
		if (note < 10) {
			return null;
		}
		if (note <= 12) {
			return PASSABLE;
		}
		if (note <= 14) {
			return BIEN;
		}
		if (note <= 16) {
			return TRES_BIEN;
		}
		return EXCELLENT;
	}
	
	@Override
	public String toString() {
		switch (this) {
		case PASSABLE:
			return "passable";
		case BIEN:
			return "bien"; 
		case TRES_BIEN:
			return "très bien";
		default:
			return "excellent";
		}
	}

}
