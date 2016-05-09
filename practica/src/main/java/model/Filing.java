package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import parser.jaxbParser.DateAdapter;

@XmlRootElement(name = "Filing")
public class Filing {
	private Date dt;
	private Date formVrsn;
	private int info_id;
	private int id;

	public Date getDt() {
		return dt;
	}

	@XmlAttribute(name = "Dt")
	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Date getFormVrsn() {
		return formVrsn;
	}

	@XmlAttribute(name = "FormVrsn")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public void setFormVrsn(Date formVrsn) {
		this.formVrsn = formVrsn;
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

}
