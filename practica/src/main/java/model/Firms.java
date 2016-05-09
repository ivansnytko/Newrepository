package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Firms")
public class Firms {
	private ArrayList<Firm> listFirms = new ArrayList<Firm>();

	public ArrayList<Firm> getListFirms() {
		return listFirms;
	}

	@XmlElement(name = "Firm")
	public void setListFirms(ArrayList<Firm> listFirms) {
		this.listFirms = listFirms;
	}

}
