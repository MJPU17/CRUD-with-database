package co.edu.unbosque.model;

public class ClownDTO extends PersonDTO{
	
	private int idClown;
	private int numberFriends;
	
	public ClownDTO() {
		super();
	}

	public ClownDTO(int id, long numberCard, String name, String studyLevel, int idClown,int numberFriends) {
		super(id, numberCard, name, studyLevel);
		this.idClown=idClown;
		this.numberFriends = numberFriends;
	}

	public int getNumberFriends() {
		return numberFriends;
	}

	public void setNumberFriends(int numberFriends) {
		this.numberFriends = numberFriends;
	}

	public int getIdClown() {
		return idClown;
	}

	public void setIdClown(int idClown) {
		this.idClown = idClown;
	}

	@Override
	public String toString() {
		return "[" + idClown + numberFriends + numberCard +  name + studyLevel + "]";
	}
	
	

}
