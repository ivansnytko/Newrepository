package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MainAddr")
public class MainAddr {
	private String strt1;
	private String strt2;
	private String city;
	private String state;
	private String cntry;
	private String postlCd;
	private String phNb;
	private String faxNb;
	private int info_id;
	private int id;

	public String getStrt1() {
		return strt1;
	}

	@XmlAttribute(name = "Strt1")
	public void setStrt1(String strt1) {
		this.strt1 = strt1;
	}

	public String getStrt2() {
		return strt2;
	}

	@XmlAttribute(name = "Strt2")
	public void setStrt2(String strt2) {
		this.strt2 = strt2;
	}

	public String getCity() {
		return city;
	}

	@XmlAttribute(name = "City")
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@XmlAttribute(name = "State")
	public void setState(String state) {
		this.state = state;
	}

	public String getCntry() {
		return cntry;
	}

	@XmlAttribute(name = "Cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public String getPostlCd() {
		return postlCd;
	}

	@XmlAttribute(name = "PostlCd")
	public void setPostlCd(String postlCd) {
		this.postlCd = postlCd;
	}

	public String getPhNb() {
		return phNb;
	}

	@XmlAttribute(name = "PhNb")
	public void setPhNb(String phNb) {
		this.phNb = phNb;
	}

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFaxNb() {
		return faxNb;
	}
	@XmlAttribute(name = "FaxNb")
	public void setFaxNb(String faxNb) {
		this.faxNb = faxNb;
	}



}
