package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Info")
public class NoticeFiled {

	private ArrayList<States> listStates = new ArrayList<States>();

	public ArrayList<States> getListStates() {
		return listStates;
	}

	@XmlElement(name = "States")
	public void setListStates(ArrayList<States> listStates) {
		this.listStates = listStates;
	}

}
