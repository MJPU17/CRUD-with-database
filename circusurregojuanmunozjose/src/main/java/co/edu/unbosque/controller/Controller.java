package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistence.ClownDAO;
import co.edu.unbosque.model.persistence.ComedianDAO;
import co.edu.unbosque.model.persistence.PersonDAO;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener,DocumentListener{
	
	private int type;
	private PersonDAO people;
	private ComedianDAO comedians;
	private ClownDAO clowns;
	private String[] cclowns= {"ID","NumberCard","Name","Study Level","Number friends"},ccomedia={"ID","NumberCard","Name","Study Level","Openmic"};
	private String[] cperson= {"ID","NumberCard","Name","Study Level","Type"};
	private MainWindow view;
	
	
	public Controller() {
		people=new PersonDAO();
		comedians=new ComedianDAO(people.getPeople());
		clowns=new ClownDAO(people.getPeople());
		view=new MainWindow();
	}
	
	public void assignListeners() {
		view.getPmenu().getBclown().addActionListener(this);
		view.getPmenu().getBcomedian().addActionListener(this);
		view.getPmenu().getBall().addActionListener(this);
		view.getPcrud().getPotion().getBcreate().addActionListener(this);
		view.getPcrud().getPotion().getBupdate().addActionListener(this);
		view.getPcrud().getPotion().getBdelete().addActionListener(this);
		view.getPcrud().getPotion().getBshow().addActionListener(this);
		view.getPcrud().getPotion().getBmenu().addActionListener(this);
		view.getPcrud().getPdata().getBclear().addActionListener(this);
		view.getPcrud().getPdata().getBcreate().addActionListener(this);
		view.getPcrud().getPdata().getBupdate().addActionListener(this);
		view.getPcrud().getPlist().getBremove().addActionListener(this);
		view.getPcrud().getPlist().getTflist().getDocument().addDocumentListener(this);
		view.getPshow().getBback().addActionListener(this);
		view.getPshow().getTflist().getDocument().addDocumentListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		
		switch (comando) {
		case "CLOWNS":{
			type=1;
			view.getPmenu().setVisible(false);
			view.getPcrud().getPdata().getLextra().setText("Enter number of friends: ");
			view.getPcrud().getPdata().getTid().setText("");
			view.getPcrud().getPdata().getTnumbercard().setText("");
			view.getPcrud().getPdata().getTname().setText("");
			view.getPcrud().getPdata().getTstudylevel().setText("");
			view.getPcrud().getPdata().getTextra().setText("");
			view.getPcrud().getPdata().getTextra().setVisible(true);
			view.getPcrud().getPdata().getCbopenmic().setVisible(false);
			view.getPcrud().getPdata().getBupdate().setVisible(false);
			view.getPcrud().getPdata().getBcreate().setVisible(true);
			view.getPcrud().getPlist().setVisible(false);
			view.getPcrud().getPdata().setVisible(true);
			view.getPcrud().setVisible(true);
			break;
		}
		case "COMEDIANS":{
			type=2;
			view.getPmenu().setVisible(false);
			view.getPcrud().getPdata().getLextra().setText("Open mic?: ");
			view.getPcrud().getPdata().getTid().setText("");
			view.getPcrud().getPdata().getTnumbercard().setText("");
			view.getPcrud().getPdata().getTname().setText("");
			view.getPcrud().getPdata().getTstudylevel().setText("");
			view.getPcrud().getPdata().getTextra().setText("");
			view.getPcrud().getPdata().getTextra().setVisible(false);
			view.getPcrud().getPdata().getCbopenmic().setVisible(true);
			view.getPcrud().getPdata().getBupdate().setVisible(false);
			view.getPcrud().getPdata().getBcreate().setVisible(true);
			view.getPcrud().getPlist().setVisible(false);
			view.getPcrud().getPdata().setVisible(true);
			view.getPcrud().setVisible(true);
			break;
		}
		case "SHOW ALL":{
			type=0;
			view.getPmenu().setVisible(false);
			view.getPshow().getTflist().setText("");
			insertAllData();
			view.getPshow().setVisible(true);
			break;
		}
		case "CREATE":{
			view.getPcrud().getPlist().setVisible(false);
			view.getPcrud().getPdata().getTid().setText("");
			view.getPcrud().getPdata().getTnumbercard().setText("");
			view.getPcrud().getPdata().getTname().setText("");
			view.getPcrud().getPdata().getTstudylevel().setText("");
			view.getPcrud().getPdata().getTextra().setText("");
			view.getPcrud().getPdata().getBupdate().setVisible(false);
			view.getPcrud().getPdata().getBcreate().setVisible(true);
			view.getPcrud().getPdata().setVisible(true);
			break;
		}
		case "UPDATE":{
			view.getPcrud().getPlist().setVisible(false);
			view.getPcrud().getPdata().getTid().setText("");
			view.getPcrud().getPdata().getTnumbercard().setText("");
			view.getPcrud().getPdata().getTname().setText("");
			view.getPcrud().getPdata().getTstudylevel().setText("");
			view.getPcrud().getPdata().getTextra().setText("");
			view.getPcrud().getPdata().getBcreate().setVisible(false);
			view.getPcrud().getPdata().getBupdate().setVisible(true);
			view.getPcrud().getPdata().setVisible(true);
			break;
		}
		case "DELETE":{
			view.getPcrud().getPdata().setVisible(false);
			view.getPcrud().getPlist().getTflist().setText("");
			insertData();
			view.getPcrud().getPlist().getBremove().setVisible(true);
			view.getPcrud().getPlist().setVisible(true);
			break;
		}
		case "SHOW":{
			view.getPcrud().getPdata().setVisible(false);
			view.getPcrud().getPlist().getTflist().setText("");
			insertData();
			view.getPcrud().getPlist().getBremove().setVisible(false);
			view.getPcrud().getPlist().setVisible(true);
			break;
		}
		case "MENU":{
			view.getPcrud().setVisible(false);
			view.getPmenu().setVisible(true);
			break;
		}
		case "CLEAR":{
			view.getPcrud().getPdata().getTid().setText("");
			view.getPcrud().getPdata().getTnumbercard().setText("");
			view.getPcrud().getPdata().getTname().setText("");
			view.getPcrud().getPdata().getTstudylevel().setText("");
			view.getPcrud().getPdata().getTextra().setText("");
			break;
		}
		case "SAVE":{
			String id=view.getPcrud().getPdata().getTid().getText();
			String numberCard=view.getPcrud().getPdata().getTnumbercard().getText();
			String name=view.getPcrud().getPdata().getTname().getText();
			String studyLevel=view.getPcrud().getPdata().getTstudylevel().getText();
			boolean isInt=PopUpMessages.isInt(id, view, "Invalid id");
			boolean isLong=PopUpMessages.isLong(numberCard, view, "Invalid number card");
			if(type==1) {
				String extra=view.getPcrud().getPdata().getTextra().getText();
				boolean isInt2=PopUpMessages.isInt(extra, view, "Invalid number of friends");
				if(isLong&&people.containsId(Long.parseLong(numberCard))) PopUpMessages.errorMessage(view, "The number card already exists, please enter another one.");
				if(isInt&&clowns.containsId(Integer.parseInt(id))) PopUpMessages.errorMessage(view, "The number ID already exists, please enter another one.");
				if(isLong&&isInt&&isInt2&&!people.containsId(Long.parseLong(id)) && !clowns.containsId(Integer.parseInt(id))) {
					ClownDTO clown=new ClownDTO(people.generateID(), Long.parseLong(numberCard), name, studyLevel, Integer.parseInt(id), Integer.parseInt(extra));
					people.create(clown);
					clowns.create(clown);
					PopUpMessages.informationMessage(view, "Clown successfully created.");
					view.getPcrud().getPdata().getTid().setText("");
					view.getPcrud().getPdata().getTnumbercard().setText("");
					view.getPcrud().getPdata().getTname().setText("");
					view.getPcrud().getPdata().getTstudylevel().setText("");
					view.getPcrud().getPdata().getTextra().setText("");
				}
			}
			else if(type==2) {
				boolean openmic=view.getPcrud().getPdata().getCbopenmic().getSelectedIndex()==0;
				if(isLong&&people.containsId(Long.parseLong(numberCard))) PopUpMessages.errorMessage(view, "The number card already exists, please enter another one.");
				if(isInt&&comedians.containsId(Integer.parseInt(id))) PopUpMessages.errorMessage(view, "The number ID already exists, please enter another one.");
				if(isInt&&isLong&&!people.containsId(Long.parseLong(numberCard)) && !comedians.containsId(Integer.parseInt(id))) {
					ComedianDTO comedian=new ComedianDTO(people.generateID(), Long.parseLong(numberCard), name, studyLevel, Integer.parseInt(id), openmic);
					people.create(comedian);
					comedians.create(comedian);
					PopUpMessages.informationMessage(view, "Comedian successfully created.");
					view.getPcrud().getPdata().getTid().setText("");
					view.getPcrud().getPdata().getTnumbercard().setText("");
					view.getPcrud().getPdata().getTname().setText("");
					view.getPcrud().getPdata().getTstudylevel().setText("");
					view.getPcrud().getPdata().getTextra().setText("");
				}
			}
			break;
		}
		case "UPDATE PERSON":{
			String id=view.getPcrud().getPdata().getTid().getText();
			String numberCard=view.getPcrud().getPdata().getTnumbercard().getText();
			String name=view.getPcrud().getPdata().getTname().getText();
			String studyLevel=view.getPcrud().getPdata().getTstudylevel().getText();
			boolean isInt=PopUpMessages.isInt(id, view, "Invalid id");
			boolean isLong=PopUpMessages.isLong(numberCard, view, "Invalid number card");
			if(type==1) {
				String extra=view.getPcrud().getPdata().getTextra().getText();
				boolean isInt2=PopUpMessages.isInt(extra, view, "Invalid number of friends");
				if(isInt&&!clowns.containsId(Integer.parseInt(id))) PopUpMessages.errorMessage(view, "The ID does not exist, please enter an existing one.");
				if(isLong&&isInt&&isInt2&& clowns.containsId(Integer.parseInt(id))) {
					ClownDTO clown=new ClownDTO(people.generateID(), Long.parseLong(numberCard), name, studyLevel, Integer.parseInt(id), Integer.parseInt(extra));
					people.update(clowns.obtainNumberCard(Integer.parseInt(id)), clown);
					clowns.update(Integer.parseInt(id),clown);
					PopUpMessages.informationMessage(view, "Clown successfully update.");
					view.getPcrud().getPdata().getTid().setText("");
					view.getPcrud().getPdata().getTnumbercard().setText("");
					view.getPcrud().getPdata().getTname().setText("");
					view.getPcrud().getPdata().getTstudylevel().setText("");
					view.getPcrud().getPdata().getTextra().setText("");
				}
			}
			else if(type==2) {
				boolean openmic=view.getPcrud().getPdata().getCbopenmic().getSelectedIndex()==0;
				if(isInt&&!comedians.containsId(Integer.parseInt(id))) PopUpMessages.errorMessage(view, "The ID does not exist, please enter an existing one.");
				if(isInt&&isLong&& comedians.containsId(Integer.parseInt(id))) {
					ComedianDTO comedian=new ComedianDTO(people.generateID(), Long.parseLong(numberCard), name, studyLevel, Integer.parseInt(id), openmic);
					people.update(comedians.obtainNumberCard(Integer.parseInt(id)), comedian);
					comedians.update(Integer.parseInt(id),comedian);
					PopUpMessages.informationMessage(view, "Comedian successfully update.");
					view.getPcrud().getPdata().getTid().setText("");
					view.getPcrud().getPdata().getTnumbercard().setText("");
					view.getPcrud().getPdata().getTname().setText("");
					view.getPcrud().getPdata().getTstudylevel().setText("");
					view.getPcrud().getPdata().getTextra().setText("");
				}
			}
			break;
		}
		case "ELIMINATE":{
			int i=view.getPcrud().getPlist().getTlist().getSelectedRow();
			if(i>=0) {
				int option=PopUpMessages.confirmMessage("He surely wants to eliminate the "+(type==1?"clown":"comedian")+".", view);
				if(option==0) {
					int id=Integer.parseInt((String)view.getPcrud().getPlist().getTlist().getValueAt(i, 0));
					if(type==1) {
						people.delete(clowns.obtainNumberCard(id));
						clowns.delete(id);
					}
					else if(type==2) {
						people.delete(comedians.obtainNumberCard(id));
						comedians.delete(id);
					}
					PopUpMessages.informationMessage(view, (type==1?"Clown":"Comedian")+" successfully delete.");
					view.getPcrud().getPlist().getTflist().setText("");
					insertData();
				}
			}
			else {
				PopUpMessages.errorMessage(view, "Please select item to delete.");
			}
			break;
		}
		case "BACK":{
			view.getPshow().setVisible(false);
			view.getPmenu().setVisible(true);
			break;
		}
		}
		
	}
	
	public void	insertData() {
		DefaultTableModel model=new DefaultTableModel();
		String[][] data;
		if(type==1) {
			data=new String[clowns.getClowns().size()][5];
			int i=0;
			for(ClownDTO clown: clowns.getClowns().values()) {
				data[i][0]=Integer.toString(clown.getIdClown());
				data[i][1]=Long.toString(clown.getNumberCard());
				data[i][2]=clown.getName();
				data[i][3]=clown.getStudyLevel();
				data[i][4]=Integer.toString(clown.getNumberFriends());
				i++;
			}
			model=new DefaultTableModel(data, cclowns) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		}
		else if(type==2) {
			data=new String[comedians.getComedians().size()][5];
			int i=0;
			for(ComedianDTO comedian: comedians.getComedians().values()) {
				data[i][0]=Integer.toString(comedian.getIdComedian());
				data[i][1]=Long.toString(comedian.getNumberCard());
				data[i][2]=comedian.getName();
				data[i][3]=comedian.getStudyLevel();
				data[i][4]=comedian.isOpenmic()?"Yes":"No";
				i++;
			}
			model=new DefaultTableModel(data, ccomedia) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		}
		view.getPcrud().getPlist().getTlist().setModel(model);
	}
	
	public void insertAllData() {
		String[][] data=new String[people.getPeople().size()][5];
		int i=0;
		for(PersonDTO person: people.getPeople().values()) {
			data[i][0]=Integer.toString(person.getId());
			data[i][1]=Long.toString(person.getNumberCard());
			data[i][2]=person.getName();
			data[i][3]=person.getStudyLevel();
			data[i][4]=person instanceof ClownDTO?"Clown":"Comedian";
			i++;
		}
		view.getPshow().getTlist().setModel(new DefaultTableModel(data, cperson) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}
	
	public void selectData(String filter) {
		if(type==1) {
			ArrayList<ClownDTO> clownData=new ArrayList<>();
			for(ClownDTO clown:clowns.getClowns().values()) {
				if(clown.toString().contains(filter.trim())) {
					clownData.add(clown);
				}
			}
			String data[][]=new String[clownData.size()][5];
			int i=0;
			for(ClownDTO clown: clownData) {
				data[i][0]=Integer.toString(clown.getIdClown());
				data[i][1]=Long.toString(clown.getNumberCard());
				data[i][2]=clown.getName();
				data[i][3]=clown.getStudyLevel();
				data[i][4]=Integer.toString(clown.getNumberFriends());
				i++;
			}
			view.getPcrud().getPlist().getTlist().setModel(new DefaultTableModel(data, cclowns) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		}
		else if(type==2) {
			ArrayList<ComedianDTO> comedianData=new ArrayList<>();
			for(ComedianDTO comedian: comedians.getComedians().values()) {
				if(comedian.toString().contains(filter.trim())) {
					comedianData.add(comedian);
				}
			}
			String data[][]=new String[comedianData.size()][5];
			int i=0;
			for(ComedianDTO comedian: comedianData) {
				data[i][0]=Integer.toString(comedian.getIdComedian());
				data[i][1]=Long.toString(comedian.getNumberCard());
				data[i][2]=comedian.getName();
				data[i][3]=comedian.getStudyLevel();
				data[i][4]=comedian.isOpenmic()?"Yes":"No";
				i++;
			}
			view.getPcrud().getPlist().getTlist().setModel(new DefaultTableModel(data, ccomedia) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		}
		else if(type==0) {
			ArrayList<PersonDTO> personData=new ArrayList<>();
			for(PersonDTO person:people.getPeople().values()) {
				if(person.toPersonString().contains(filter.trim())) {
					personData.add(person);
				}
			}
			String data[][]=new String[personData.size()][5];
			int i=0;
			for(PersonDTO person: personData) {
				data[i][0]=Integer.toString(person.getId());
				data[i][1]=Long.toString(person.getNumberCard());
				data[i][2]=person.getName();
				data[i][3]=person.getStudyLevel();
				data[i][4]=person instanceof ClownDTO?"Clown":"Comedian";
				i++;
			}
			view.getPshow().getTlist().setModel(new DefaultTableModel(data, ccomedia) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		}
	}
	
	

	@Override
	public void insertUpdate(DocumentEvent e) {
		String filter="";
		if(type==1||type==2) {
			filter=view.getPcrud().getPlist().getTflist().getText();
		}
		if(type==0) {
			filter=view.getPshow().getTflist().getText();
		}
		selectData(filter);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String filter="";
		if(type==1||type==2) {
			filter=view.getPcrud().getPlist().getTflist().getText();
		}
		if(type==0) {
			filter=view.getPshow().getTflist().getText();
		}
		selectData(filter);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
