package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rgstn")
public class Rgstn {
	private String firmtype;
	private String st;
	private Date dt;
	private int info_id;
	private int id_rgstn;

	public String getFirmType() {
		return firmtype;
	}

	@XmlAttribute(name = "FirmType")
	public void setFirmType(String firmType) {
		this.firmtype = firmType;
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

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getId_rgstn() {
		return id_rgstn;
	}

	public void setId_rgstn(int id_rgstn) {
		this.id_rgstn = id_rgstn;
	}

}
