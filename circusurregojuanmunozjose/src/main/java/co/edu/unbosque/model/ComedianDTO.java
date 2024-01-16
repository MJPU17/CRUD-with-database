package co.edu.unbosque.model;

public class ComedianDTO extends PersonDTO{
	
	private int idComedian;
	private boolean openmic;
	
	public ComedianDTO() {
		super();
	}

	

	public ComedianDTO(int id, long numberCard, String name, String studyLevel,int idComedian, boolean openmic) {
		super(id, numberCard, name, studyLevel);
		this.idComedian=idComedian;
		this.openmic = openmic;
	}

	public boolean isOpenmic() {
		return openmic;
	}

	public void setOpenmic(boolean openmic) {
		this.openmic = openmic;
	}

	public int getIdComedian() {
		return idComedian;
	}

	public void setIdComedian(int idComedian) {
		this.idComedian = idComedian;
	}



	@Override
	public String toString() {
		return "" + idComedian + openmic + numberCard+ name + studyLevel + "";
	}



	
	
}
