package DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import DAO.IFiling;
import model.Filing;
import model.Firm;
import parser.Main;

public class FilingImpl implements IFiling {
	public static Logger log = Logger.getLogger(FilingImpl.class.getName());

	public void insertFiling(ArrayList<Firm> listFirms, int a, Filing filing) throws SQLException, IOException {
		Connection con;
		PreparedStatement stmt;
		Main main = new Main();

		try {
			con = main.getConnection();
			for (int i = 0; i < a; i++) {
				stmt = con.prepareStatement("Insert into mydb.filing VALUES(?,?,?,?)");
				stmt.setInt(1, 0);
				Date Dt = new Date(listFirms.get(i).getFiling().getDt().getTime());
				stmt.setDate(2, Dt);
				Date FormVrsn = new Date(listFirms.get(i).getFiling().getFormVrsn().getTime());
				stmt.setDate(3, FormVrsn);
				stmt.setInt(4, listFirms.get(i).getInfo().getInfo_id());
				stmt.executeUpdate();

			}
		} catch (Exception e) {
			log.info(e.toString());
		}

	}

}
