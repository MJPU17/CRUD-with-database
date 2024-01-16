package co.edu.unbosque.model.persistence;

public interface CRUDoperation <K,T>{
	
	public void create(T o);
	public void update(K id, T o);
	public void delete(K id);
	public String readByName(String name);
	public String readAll();
	public boolean containsId(K id);
	
}
