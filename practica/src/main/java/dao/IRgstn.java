package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.Rgstn;

public interface IRgstn {
	void insertRgstn(ArrayList<Firm> listFirms, int a, Rgstn rgstn) throws SQLException, IOException;
}
