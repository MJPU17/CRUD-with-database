package co.edu.unbosque.model;

public class PersonDTO {
	
	protected int id;
	protected long numberCard;
	protected String name;
	protected String studyLevel;
	
	
	
	public PersonDTO(int id, long numberCard, String name, String studyLevel) {
		this.id = id;
		this.numberCard = numberCard;
		this.name = name;
		this.studyLevel = studyLevel;
	}

	public PersonDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(long numberCard) {
		this.numberCard = numberCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}

	@Override
	public String toString() {
		return ""+ id + numberCard  + name + studyLevel +"";
	}
	
	public String toPersonString() {
		return ""+ id + numberCard  + name + studyLevel +"";
	}

}
