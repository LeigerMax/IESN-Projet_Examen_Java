package projetExamenPackage;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import projetExamenPackage.AccessBDGen;
import projetExamenPackage.TableModelGen;

public class AfficherUneTable extends JPanel {
	private static JTable table2;
	
	public AfficherUneTable(Connection connection, String SqlSelectFrom) {
		try {
			PreparedStatement prepStat = connection.prepareStatement(SqlSelectFrom);
			TableModelGen table = AccessBDGen.creerTableModel(prepStat);
		 	table2 = new JTable(table);
		 	table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 	table2.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		 	JScrollPane scroll = new JScrollPane (table2) ;
		 	scroll.setPreferredSize(new Dimension(400, 200));
		 	this.add(scroll);
			}
		catch(SQLException e) {	}
		
		setVisible(true);
		}
	
	
	public static int getTable2 () {
		int index=0;		
		try {
			index=(int)table2.getValueAt(table2.getSelectionModel().getMinSelectionIndex(), 0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return index;
	}
}
