package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.Info;

public interface IInfo {
	void insertInfo(ArrayList<Firm> listFirms, int a, Info info) throws SQLException, IOException;
}
