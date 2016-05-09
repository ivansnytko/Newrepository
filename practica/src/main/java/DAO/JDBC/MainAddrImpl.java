package DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import DAO.IMainAddr;
import model.Firm;
import model.MainAddr;
import parser.Main;

public class MainAddrImpl implements IMainAddr {
	public static Logger log = Logger.getLogger(MainAddrImpl.class.getName());

	public void insertMainAddr(ArrayList<Firm> listFirms, int a, MainAddr mainAddr) throws SQLException, IOException {
		Connection con;
		PreparedStatement stmt2;
		Main main = new Main();

		try {
			con = main.getConnection();
			for (int i = 0; i < a; i++) {
				stmt2 = con.prepareStatement("Insert into mydb.mainaddr VALUES(?,?,?,?,?,?,?,?,?,?)");
				stmt2.setInt(1, 0);
				stmt2.setString(2, listFirms.get(i).getMainaddr().getStrt1());
				stmt2.setString(3, listFirms.get(i).getMainaddr().getStrt2());
				stmt2.setString(4, listFirms.get(i).getMainaddr().getCity());
				stmt2.setString(5, listFirms.get(i).getMainaddr().getState());
				stmt2.setString(6, listFirms.get(i).getMainaddr().getCntry());
				stmt2.setString(7, listFirms.get(i).getMainaddr().getPostlCd());
				stmt2.setString(8, listFirms.get(i).getMainaddr().getPhNb());
				stmt2.setString(9, listFirms.get(i).getMainaddr().getFaxNb());
				stmt2.setInt(10, listFirms.get(i).getInfo().getInfo_id());
				stmt2.executeUpdate();
			}
		} catch (Exception e) {
			log.info(e.toString());
		}
	}

}
