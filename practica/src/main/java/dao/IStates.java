package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.States;

public interface IStates {
	void insertStates(ArrayList<Firm> listFirms, int a, States states) throws SQLException, IOException;

}
