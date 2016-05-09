package DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import DAO.IInfo;
import model.Firm;
import model.Info;
import parser.Main;

public class InfoImpl implements IInfo {
	public static Logger log = Logger.getLogger(InfoImpl.class.getName());

	public void insertInfo(ArrayList<Firm> listFirms, int a, Info info) throws SQLException, IOException {
		Connection con;
		PreparedStatement stmt;
		Main main = new Main();

		try {
			con = main.getConnection();
			for (int i = 0; i < a; i++) {
				stmt = con.prepareStatement("Insert into mydb.info VALUES(?,?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, listFirms.get(i).getInfo().getSECRgnCD());
				stmt.setString(3, listFirms.get(i).getInfo().getFirmCrdNb());
				stmt.setString(4, listFirms.get(i).getInfo().getSECNb());
				stmt.setString(5, listFirms.get(i).getInfo().getBusNm());
				stmt.setString(6, listFirms.get(i).getInfo().getLegalNm());
				stmt.executeUpdate();
				int id = (int) ((com.mysql.jdbc.PreparedStatement) stmt).getLastInsertID();
				listFirms.get(i).getInfo().setInfo_id(id);

			}
			main.releaseConnection(con);
		} catch (Exception e) {
			log.info(e.toString());
		}
	}

}
