package DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import parser.Main;

public class FirmsImpl {
	public static Logger log = Logger.getLogger(FirmsImpl.class.getName());

	public void selectInfo() throws SQLException, IOException {
		Connection con;
		PreparedStatement stmt;
		ResultSet rs;
		Main main = new Main();

		try {
			con = main.getConnection();

			stmt = con.prepareStatement(
					"Select legalNm, count(states.info_id)	from info INNER Join states	On info.info_id = states.info_id Group by states.info_id Having count(states.info_id) >= 2 ");
			rs = stmt.executeQuery();
			while (rs.next()) {
				log.info(rs.getString(1) + " " + rs.getInt(2));
			}
			main.releaseConnection(con);
		} catch (Exception e) {
			log.info(e.toString());
		}

	}

	public void selectAllById() throws SQLException, IOException {
		Connection con2;
		PreparedStatement stmt2;
		ResultSet rs;
		Main main = new Main();

		try {
			con2 = main.getConnection();

			stmt2 = con2.prepareStatement(
					"SELECT * FROM info Inner join filing on info.info_id=filing.info_id Inner join mainaddr on info.info_id=mainaddr.info_id Inner join rgstn on info.info_id=rgstn.info_id Inner join states on info.info_id=states.info_id where info.info_id = 2");
			rs = stmt2.executeQuery();
			while (rs.next()) {
				log.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "
						+ rs.getString(5) + " " + rs.getString(6));
			}
			main.releaseConnection(con2);
		} catch (Exception e) {
			log.info(e.toString());
		}
	}
}
