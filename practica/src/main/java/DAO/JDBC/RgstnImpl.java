package DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;

import DAO.IRgstn;
import model.Firm;
import model.Rgstn;
import parser.Main;

public class RgstnImpl implements IRgstn {
	public static Logger log = Logger.getLogger(RgstnImpl.class.getName());

	public void insertRgstn(ArrayList<Firm> listFirms, int a, Rgstn rgstn) {
		Connection con;
		PreparedStatement stmt;
		Main main = new Main();

		try {
			con = main.getConnection();
			for (int i = 0; i < a; i++) {
				stmt = con.prepareStatement("Insert into mydb.rgstn VALUES(?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, listFirms.get(i).getRgstn().getFirmType());
				stmt.setString(3, listFirms.get(i).getRgstn().getSt());
				Date Dt = new Date(listFirms.get(i).getRgstn().getDt().getTime());
				stmt.setDate(4, Dt);
				stmt.setInt(5, listFirms.get(i).getInfo().getInfo_id());
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			log.info(e.toString());
		}

	}
}
