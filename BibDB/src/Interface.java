import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Interface extends JFrame {
	JLabel keyLabel = new JLabel("key");
	JTextField keyField = new JTextField(40); 
	JLabel authorLabel = new JLabel("authors");
	JTextField authorField = new JTextField(40);
	JLabel titleLabel = new JLabel("title");
	JTextField titleField = new JTextField(40);
	JLabel yearLabel = new JLabel("year");
	JTextField yearField = new JTextField(40);
	JButton doneBtn = new JButton("make file");
	JButton sendToDBBtn = new JButton("send to DB");
	JButton authorBtn = new JButton("modify info");
	JButton titleBtn = new JButton("chqnge title");
	JButton yearBtn = new JButton("change year");
	JButton showBtn = new JButton("show info");

	
	JLabel aKeyLabel = new JLabel("keys");
	JTextField dAuthorField = new JTextField(50);
	JTextField dTitleField = new JTextField(50);
	JTextField dYearField = new JTextField(50);

	JButton deleteBtn = new JButton("delete item from DB");
	
	JButton dbToFileBtn = new JButton("DB to File");

	
	String SKey =  new String();
	String Sauthor = new String();
	String STitle = new String();
	String SYear = new String();
	
	JList keyList = new JList();
		
	public String[] stringOut(){
		
		String a[] = {SKey,Sauthor,STitle,SYear};
		return a;
	}
	
	Interface(){
		setTitle("Bibtex Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		

		class DoneListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				SKey = keyField.getText();
				Sauthor = authorField.getText();
				STitle = titleField.getText();
				SYear = yearField.getText();
				String s[] = {SKey,Sauthor,STitle,SYear};
				System.out.println(SKey+"\n"+Sauthor+"\n"+STitle+"\n"+SYear);
				new BibMaker(s);
				keyField.setText("");
				authorField.setText("");
				titleField.setText("");
				yearField.setText("");

			}
		}
		
		class SendDBListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				SKey = keyField.getText();
				Sauthor = authorField.getText();
				STitle = titleField.getText();
				SYear = yearField.getText();
				String s[] = {SKey,Sauthor,STitle,SYear};
				new DBManager(s);
				keyField.setText("");
				authorField.setText("");
				titleField.setText("");
				yearField.setText("");
				
				DBLoader dl = new DBLoader();
				String[] data= new String[1000];
				data= dl.getIDFromDB();
				keyList.setListData(data);
			}
		}
		
		class DtoFListener implements ActionListener{
		
			public void actionPerformed(ActionEvent e){
				DBLoader db = new DBLoader();
				BibMaker dbm = new BibMaker();
				dbm.makeDBtoFile(db.getAllFromDB());				
			}
		}
		
		class ShowListener implements ActionListener{		
			public void actionPerformed(ActionEvent e){
			    String s = (String) keyList.getSelectedValue();
			    DBLoader dbl = new DBLoader();
			    String data[] = dbl.getOneFromDB(s);
			    dAuthorField.setText(data[0]);
			    dTitleField.setText(data[1]);
			    dYearField.setText(data[2]);
			}
		}
		
		class ChangeBtnListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
			    String s = (String) keyList.getSelectedValue();
			    DBManager dbm = new DBManager();
			    String ns[] = new String[5];
			    ns[0] = s;
			    ns[1] = dAuthorField.getText();
			    ns[2] = dTitleField.getText();
			    ns[3] = dYearField.getText();
			    dbm.changeItem(ns);
			}
		}
	    
		class DeleteBtnListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
			    String s = (String) keyList.getSelectedValue();
			    DBManager dbm = new DBManager();
			    dbm.deleteItem(s);
			    DBLoader dl = new DBLoader();
			    String[] data= new String[1000];
			    data= dl.getIDFromDB();
				keyList.setListData(data);
				dAuthorField.setText("");
				dTitleField.setText("");
				dYearField.setText("");
			}
		}
//		
//		class ListListener implements ListSelectionListener {
//		    public void valueChanged(ListSelectionEvent e) {
//		       
//		    }
//		}
	
		doneBtn.addActionListener(new DoneListener());
		sendToDBBtn.addActionListener(new SendDBListener() );
		
		JLabel inputLabel = new JLabel("input field");
		inputLabel.setLocation(215,5);
		inputLabel.setSize(100,30);
		c.add(inputLabel);
		keyLabel.setLocation(50,30);
		keyLabel.setSize(50,30);
		c.add(keyLabel);
		keyField.setLocation(100,30);
		keyField.setSize(300,30);
		c.add(keyField);
		authorLabel.setLocation(40,60);
		authorLabel.setSize(50,30);
		c.add(authorLabel);
		authorField.setLocation(100,60);
		authorField.setSize(300,30);
		c.add(authorField);
		titleLabel.setLocation(50,90);
		titleLabel.setSize(50,30);
		c.add(titleLabel);
		titleField.setLocation(100,90);
		titleField.setSize(300,30);
		c.add(titleField);
		yearLabel.setLocation(50,120);
		yearLabel.setSize(50,30);
		c.add(yearLabel);
		yearField.setLocation(100,120);
		yearField.setSize(300,30);
		c.add(yearField);
		doneBtn.setLocation(150,150);
		doneBtn.setSize(100,30);
		c.add(doneBtn);	
		sendToDBBtn.setLocation(250,150);
		sendToDBBtn.setSize(100,30);
		c.add(sendToDBBtn);
		
		JLabel modLabel = new JLabel("modification field");
		modLabel.setLocation(615,5);
		modLabel.setSize(200,30);
		c.add(modLabel);
//		aKeyLabel.setLocation(465,25);
//		aKeyLabel.setSize(150,30);
//		c.add(aKeyLabel);
		
		showBtn.addActionListener(new ShowListener());
		showBtn.setLocation(450,25);
		showBtn.setSize(100,30);
		c.add(showBtn);	
		
		
		DBLoader dl = new DBLoader();
		String s[] = new String[1000];
		s= dl.getIDFromDB();
		keyList.setListData(s);
		//JList keyList = new JList(lModel);
	
	//	keyList.addListSelectionListener(ListSelectionListener);
		JScrollPane scrollKey = new JScrollPane(keyList);
		scrollKey.setLocation(450,50);
		scrollKey.setSize(100,100);
		c.add(scrollKey);

		authorBtn.addActionListener(new ChangeBtnListener());
		authorBtn.setLocation(850,80);
		authorBtn.setSize(130,30);
		c.add(authorBtn);
		dAuthorField.setLocation(550,50);
		dAuthorField.setSize(300,30);
		c.add(dAuthorField);
		
		titleBtn.setLocation(850,80);
		titleBtn.setSize(130,30);
	//	c.add(titleBtn);
		dTitleField.setLocation(550,80);
		dTitleField.setSize(300,30);
		c.add(dTitleField);
		
		yearBtn.setLocation(850,110);
		yearBtn.setSize(130,30);
	//	c.add(yearBtn);
		dYearField.setLocation(550,110);
		dYearField.setSize(300,30);
		c.add(dYearField);
		
		deleteBtn.addActionListener(new DeleteBtnListener());
		deleteBtn.setLocation(500,160);
		deleteBtn.setSize(180,30);
		c.add(deleteBtn);
		
		dbToFileBtn.addActionListener(new DtoFListener());
		dbToFileBtn.setLocation(700,160);
		dbToFileBtn.setSize(180,30);
		c.add(dbToFileBtn);
		
		setSize(1000,250);
		setVisible(true);
	}
	
}
