package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Info")
public class Info {
	private int info_id;
	private String sECRgnCD;
	private String firmCrdNb;
	private String sECNb;//
	private String busNm;
	private String legalNm;

	public String getSECRgnCD() {
		return sECRgnCD;
	}

	@XmlAttribute(name = "SECRgnCD")
	public void setSECRgnCD(String sECRgnCD) {
		this.sECRgnCD = sECRgnCD;
	}

	public String getFirmCrdNb() {
		return firmCrdNb;
	}

	@XmlAttribute(name = "FirmCrdNb")
	public void setFirmCrdNb(String firmCrdNb) {
		this.firmCrdNb = firmCrdNb;
	}

	public String getSECNb() {
		return sECNb;
	}

	@XmlAttribute(name = "SECNb")
	public void setSECNb(String sECNb) {
		this.sECNb = sECNb;
	}

	public String getBusNm() {
		return busNm;
	}

	@XmlAttribute(name = "BusNm")
	public void setBusNm(String busNm) {
		this.busNm = busNm;
	}

	public String getLegalNm() {
		return legalNm;
	}

	@XmlAttribute(name = "LegalNm")
	public void setLegalNm(String legalNm) {
		this.legalNm = legalNm;
	}
	
	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}


	

}
