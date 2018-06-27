import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="projet", schema = "exorm", catalog = "")
public class Projet extends Examen {

    @Id
	@Column(name = "projetID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private static final float NOTE_MAX = 10;

    @Basic
    @Column(name = "projetNoteEcrite", nullable = false)
	private float noteEcrite;
    @Basic
    @Column(name = "projetNoteorale", nullable = false)
	private float noteOrale;
    @Basic
    @Column(name = "projetAppreciationOral", nullable = false)
	private String appreciationOral;
    @Basic
    @Column(name = "projetAppreciationEcrite", nullable = false)
	private String appreciationEcrit;
    @OneToOne
    private Examen examen;
	
	public void setNote(float oral, float ecrit) throws NoteInvalideException {
		checkNote(oral);
		checkNote(ecrit);
		this.noteOrale = oral;
		this.noteEcrite = ecrit;
	}
	
	@Override
	public float getNote() {
		return this.noteOrale + this.noteEcrite;
	}

	private void checkNote(float note) throws NoteInvalideException {
		if (note < 0 || note > NOTE_MAX) {
			throw new NoteInvalideException(note, NOTE_MAX);
		}
	}

	@Override
	public String getAppreciation() {
		return String.format("Oral : %s / Écrit : %s", 
				Objects.toString(this.appreciationOral, "aucune appréciation"), 
				Objects.toString(this.appreciationEcrit, "aucune appréciation"));
	}
	public void setAppreciationOral(String appreciationOral) {
		this.appreciationOral = appreciationOral;
	}

	public void setAppreciationEcrit(String appreciationEcrit) {
		this.appreciationEcrit = appreciationEcrit;
	}

}
