package model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "IAPDFirmSECReport")
public class IAPDFirmSECReport {
	
	private String genOn;
	private Firms firms;

	public String getGenOn() {
		return genOn;
	}
	@XmlAttribute(name ="GenOn")
	public void setGenOn(String genOn) {
		this.genOn = genOn;
	}

	public Firms getFirms() {
		return firms;
	}
	@XmlElement(name = "Firms")
	public void setFirms(Firms firms) {
		this.firms = firms;
	}
	
}
