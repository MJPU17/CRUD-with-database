package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;

public class ComedianDAO implements CRUDoperation<Integer,ComedianDTO>{
	
	private DBConnection dbcon;
	private HashMap<Integer, ComedianDTO> comedians;
	
	public ComedianDAO() {
		dbcon=new DBConnection();
		comedians=new HashMap<>();
	}
	
	public ComedianDAO(HashMap<Long, PersonDTO> people) {
		dbcon=new DBConnection();
		comedians=new HashMap<>();
		loadData(people);
		
	}

	public HashMap<Integer, ComedianDTO> getComedians() {
		return comedians;
	}



	public void setComedians(HashMap<Integer, ComedianDTO> comedians) {
		this.comedians = comedians;
	}

	@Override
	public void create(ComedianDTO o) {
		ComedianDTO newComedian=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO comedian VALUES(?,?,?);"));
			dbcon.getPreparedstatement().setInt(1, newComedian.getIdComedian());
			dbcon.getPreparedstatement().setLong(2, newComedian.getNumberCard());
			dbcon.getPreparedstatement().setBoolean(3, newComedian.isOpenmic());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		comedians.put(newComedian.getIdComedian(), newComedian);
	}

	@Override
	public void update(Integer id, ComedianDTO o) {
		ComedianDTO newComedian=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE comedian SET numbercard=?,openmic=? WHERE idcomedian=?;"));
			dbcon.getPreparedstatement().setLong(1, newComedian.getNumberCard());
			dbcon.getPreparedstatement().setBoolean(2, newComedian.isOpenmic());
			dbcon.getPreparedstatement().setInt(3, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		comedians.replace(id, newComedian);
	}

	@Override
	public void delete(Integer id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM comedian WHERE idcomedian=?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comedians.remove(id);	
	}

	@Override
	public String readByName(String name) {
		String exit="";
		for(ComedianDTO comedian : comedians.values()) {
			if(comedian.getName().equals(name)) {
				exit+=(comedian.toString()+"\n");
			}
		}
		return exit;
	}

	@Override
	public String readAll() {
		String exit="";
		for(ComedianDTO comedian : comedians.values()) {
			exit+=(comedian.toString()+"\n");
		}
		return exit;
	}
	
	public void loadData(HashMap<Long, PersonDTO> people) {
		for(PersonDTO person: people.values()) {
			if(person instanceof ComedianDTO) {
				ComedianDTO comedian=(ComedianDTO)person;
				comedians.put(comedian.getIdComedian(), comedian);
			}
		}
	}

	@Override
	public boolean containsId(Integer id) {
		return comedians.containsKey(id);
	}
	
	public long obtainNumberCard(Integer id) {
		return comedians.get(id).getNumberCard();
	}
	
	public int idPerson(int id) {
		return comedians.get(id).getId();
	}

}
