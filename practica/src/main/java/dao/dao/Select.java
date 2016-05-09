package dao.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import dao.ConnectionPoolDAO;

public class Select {
	public static Logger log = Logger.getLogger(MainAddrImpl.class.getName());

	public void selectInfo() throws SQLException, IOException {
		Connection con = null;

		ConnectionPoolDAO dsc = new ConnectionPoolDAO();
		DataSource dataSource = null;
		try {
			dataSource = dsc.setupDataSource();
		} catch (FileNotFoundException e2) {
			log.info(e2.toString());
		} catch (IOException e2) {
			log.info(e2.toString());
		}

		PreparedStatement stmt2;
		ResultSet rs;
		try {
			con = dataSource.getConnection();

			stmt2 = con.prepareStatement(
					"Select legalNm, count(states.info_id)	from info INNER Join states	On info.info_id = states.info_id Group by states.info_id Having count(states.info_id) >= 2 ");
			rs = stmt2.executeQuery();
			while (rs.next()) {
				log.info(rs.getString(1) + " " + rs.getInt(2));
			}

		} catch (Exception e) {
			log.info(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void selectAllById() throws SQLException, IOException {
		Connection con = null;

		ConnectionPoolDAO dsc = new ConnectionPoolDAO();
		DataSource dataSource = null;
		try {
			dataSource = dsc.setupDataSource();
		} catch (FileNotFoundException e2) {
			log.info(e2.toString());
		} catch (IOException e2) {
			log.info(e2.toString());
		}

		PreparedStatement stmt2;
		ResultSet rs;
		try {
			con = dataSource.getConnection();

			stmt2 = con.prepareStatement(
					"SELECT * FROM info Inner join filing on info.info_id=filing.info_id Inner join mainaddr on info.info_id=mainaddr.info_id Inner join rgstn on info.info_id=rgstn.info_id Inner join states on info.info_id=states.info_id where info.info_id = 2");
			rs = stmt2.executeQuery();
			while (rs.next()){
				log.info(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6));
			}

		} catch (Exception e) {
			log.info(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
