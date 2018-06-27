import javax.persistence.*;

@Entity
@Table(name="controle", schema = "exorm", catalog = "")
public class Controle extends Examen {

    @Id
    @Column(name = "controleID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private static final int NOTE_MAX = 20;
    @Basic
    @Column(name = "controleNote", nullable = false)
	private float note;
    @Basic
    @Column(name = "controleAppreciation", nullable = false)
	private String appreciation;
	@OneToOne
    private Examen examen;

	@Override
	public float getNote() {
		return note;
	}

	public void setNote(float note) throws NoteInvalideException {
		if (note < 0 || note > NOTE_MAX) {
			throw new NoteInvalideException(note, NOTE_MAX);
		}
		this.note = note;
	}

	@Override
	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
}
