package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "States")
public class States {
	private String rgltrCd;
	private String st;
	private Date dt;
	private int info_id;
	private int id_states;
	
	public String getRgltrCd() {
		return rgltrCd;
	}

	@XmlAttribute(name = "RgltrCd")
	public void setRgltrCd(String rgltrCd) {
		this.rgltrCd = rgltrCd;
	}

	public String getSt() {
		return st;
	}

	@XmlAttribute(name = "St")
	public void setSt(String st) {
		this.st = st;
	}

	public Date getDt() {
		return dt;
	}

	@XmlAttribute(name = "Dt")
	public void setDt(Date dt) {
		this.dt = dt;
	}

	public int getInfoid() {
		return info_id;
	}

	public void setInfoid(int infoid) {
		this.info_id = infoid;
	}

	public int getId_states() {
		return id_states;
	}

	public void setId_states(int id_states) {
		this.id_states = id_states;
	}

}
