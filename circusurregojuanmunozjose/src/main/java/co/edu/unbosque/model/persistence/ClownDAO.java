package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;

public class ClownDAO implements CRUDoperation<Integer,ClownDTO>{
	
	private DBConnection dbcon;
	private HashMap<Integer, ClownDTO> clowns;
	
	public ClownDAO() {
		dbcon=new DBConnection();
		clowns=new HashMap<>();
	}
	
	public ClownDAO(HashMap<Long, PersonDTO> people) {
		dbcon=new DBConnection();
		clowns=new HashMap<>();
		loadData(people);
	}
	
	public void loadData(HashMap<Long, PersonDTO> people) {
		for(PersonDTO person: people.values()) {
			if(person instanceof ClownDTO) {
				ClownDTO clown=(ClownDTO)person;
				clowns.put(clown.getIdClown(), clown);
			}
		}
	}

	public HashMap<Integer, ClownDTO> getClowns() {
		return clowns;
	}

	public void setClowns(HashMap<Integer, ClownDTO> clowns) {
		this.clowns = clowns;
	}

	@Override
	public void create(ClownDTO o) {
		ClownDTO newClown=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO clown VALUES(?,?,?);"));
			dbcon.getPreparedstatement().setInt(1, newClown.getIdClown());
			dbcon.getPreparedstatement().setLong(2, newClown.getNumberCard());
			dbcon.getPreparedstatement().setInt(3, newClown.getNumberFriends());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		clowns.put(newClown.getIdClown(), newClown);
		
	}

	@Override
	public void update(Integer id, ClownDTO o) {
		ClownDTO newClown=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE clown SET numbercard=?,numberfriends=? WHERE idclown=?;"));
			dbcon.getPreparedstatement().setLong(1, newClown.getNumberCard());
			dbcon.getPreparedstatement().setInt(2, newClown.getNumberFriends());
			dbcon.getPreparedstatement().setInt(3, newClown.getIdClown());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		clowns.replace(id, newClown);
	}

	@Override
	public void delete(Integer id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM clown WHERE idclown=?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		clowns.remove(id);
	}

	@Override
	public String readByName(String name) {
		String exit="";
		for(ClownDTO clown : clowns.values()) {
			if(clown.getName().equals(name)) {
				exit+=(clown.toString()+"\n");
			}
		}
		return exit;
	}

	@Override
	public String readAll() {
		String exit="";
		for(ClownDTO clown : clowns.values()) {
			exit+=(clown.toString()+"\n");
		}
		return exit;
	}

	@Override
	public boolean containsId(Integer id) {
		return clowns.containsKey(id);
	}
	
	public long obtainNumberCard(Integer id) {
		return clowns.get(id).getNumberCard();
	}
	
	public int idPerson(int id) {
		return clowns.get(id).getId();
	}
	
}
