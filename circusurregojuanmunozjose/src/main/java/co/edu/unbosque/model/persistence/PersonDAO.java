package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;

public class PersonDAO implements CRUDoperation<Long,PersonDTO>{
	
	private DBConnection dbcon;
	private HashMap<Long, PersonDTO> people;
	private HashSet<Integer> ids;
	
	public PersonDAO() {
		ids=new HashSet<>();
		dbcon=new DBConnection();
		people=loadData();
		if(people==null)people=new HashMap<>();
	}
	
	public HashMap<Long, PersonDTO> getPeople() {
		return people;
	}

	public void setPeople(HashMap<Long, PersonDTO> people) {
		this.people = people;
	}

	@Override
	public void create(PersonDTO o) {
		PersonDTO newPerson=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO person VALUES(?,?,?,?);"));
			dbcon.getPreparedstatement().setInt(1, newPerson.getId());
			dbcon.getPreparedstatement().setLong(2, newPerson.getNumberCard());
			dbcon.getPreparedstatement().setString(3, newPerson.getName());
			dbcon.getPreparedstatement().setString(4, newPerson.getStudyLevel());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		people.put(newPerson.getNumberCard(), newPerson);
		ids.add(newPerson.getId());
		
	}

	@Override
	public void update(Long id, PersonDTO o) {
		PersonDTO newPerson=o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE person SET numbercard=?, pname=?,studylevel=? WHERE numbercard=?;"));
			dbcon.getPreparedstatement().setLong(1, newPerson.getNumberCard());
			dbcon.getPreparedstatement().setString(2, newPerson.getName());
			dbcon.getPreparedstatement().setString(3, newPerson.getStudyLevel());
			dbcon.getPreparedstatement().setLong(4, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		people.remove(id);
		people.put(newPerson.getNumberCard(), newPerson);
	}
	@Override
	public void delete(Long id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM person WHERE numbercard=?;"));
			dbcon.getPreparedstatement().setLong(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ids.remove(people.get(id).getId());
		people.remove(id);
	}

	@Override
	public String readByName(String name) {
		String exit="";
		for(PersonDTO person: people.values()) {
			if(person.getName().equals(name))exit+=person.toString()+"\n";
		}
		return exit;
	}

	@Override
	public String readAll() {
		String exit="";
		for(PersonDTO person: people.values()) {
			exit+=(person.getId()+": "+person.toString()+"\n");
		}
		return exit;
	}

	@Override
	public boolean containsId(Long id) {
		return people.containsKey(id);
	}
	
	public int generateID() {
		for(int i=1;i<=ids.size();i++) {
			if(!ids.contains(i))return i;
		}
		return ids.size()+1;
	}
	
	public HashMap<Long, PersonDTO> loadData() {
		HashMap<Long, PersonDTO> data=new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT P.id AS personid, P.numbercard, P.pname, P.studylevel, C.idclown, C.numberfriends FROM person P INNER JOIN clown C ON P.numbercard = C.numbercard;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("personid");
				long numbercard=dbcon.getResultset().getLong("numbercard");
				String name=dbcon.getResultset().getString("pname");
				String studyLevel=dbcon.getResultset().getString("studylevel");
				int idClown=dbcon.getResultset().getInt("idclown");
				int numberFriends=dbcon.getResultset().getInt("numberfriends");
				data.put(numbercard, new ClownDTO(id, numbercard, name, studyLevel, idClown, numberFriends));
				ids.add(id);
			}
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT P.id AS personid, P.numbercard, P.pname, P.studylevel, C.idcomedian, C.openmic FROM person P INNER JOIN comedian C ON P.numbercard = C.numbercard;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("personid");
				long numbercard=dbcon.getResultset().getLong("numbercard");
				String name=dbcon.getResultset().getString("pname");
				String studyLevel=dbcon.getResultset().getString("studylevel");
				int idComedian=dbcon.getResultset().getInt("idcomedian");
				boolean openmic=dbcon.getResultset().getBoolean("openmic");
				data.put(numbercard, new ComedianDTO(id, numbercard, name, studyLevel, idComedian, openmic));
				ids.add(id);
			}
			dbcon.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
