package DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;

import DAO.IStates;
import model.Firm;
import model.States;
import parser.Main;

public class StatesImpl implements IStates {
	public static Logger log = Logger.getLogger(StatesImpl.class.getName());

	public void insertStates(ArrayList<Firm> listFirms, int a, States states) {
		Connection con;
		PreparedStatement stmt;
		Main main = new Main();

		try {
			con = main.getConnection();
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < listFirms.get(i).getNoticefiled().getListStates().size(); j++) {
					stmt = con.prepareStatement("Insert into mydb.states VALUES(?,?,?,?,?)");
					stmt.setInt(1, 0);
					stmt.setString(2, listFirms.get(i).getNoticefiled().getListStates().get(j).getRgltrCd());
					stmt.setString(3, listFirms.get(i).getNoticefiled().getListStates().get(j).getSt());
					Date Dt = new Date(listFirms.get(i).getNoticefiled().getListStates().get(j).getDt().getTime());
					stmt.setDate(4, Dt);
					stmt.setInt(5, listFirms.get(i).getInfo().getInfo_id());
					stmt.executeUpdate();

				}
			}
			main.releaseConnection(con);
		} catch (Exception e) {
			log.info(e.toString());
		}

	}
}
