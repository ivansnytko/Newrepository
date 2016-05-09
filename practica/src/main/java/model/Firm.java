package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Firm")
@XmlSeeAlso(value = { model.Info.class, model.MainAddr.class })

public class Firm {
	private Info info;
	private MainAddr mainaddr;
	private Rgstn rgstn;
	private NoticeFiled noticefiled;
	private Filing filing;
	private FormInfo forminfo;

	public Info getInfo() {
		return info;
	}

	@XmlElement(name = "Info")
	public void setInfo(Info info) {
		this.info = info;
	}

	public MainAddr getMainaddr() {
		return mainaddr;
	}

	@XmlElement(name = "MainAddr")
	public void setMainaddr(MainAddr mainaddr) {
		this.mainaddr = mainaddr;
	}



	public Rgstn getRgstn() {
		return rgstn;
	}

	@XmlElement(name = "Rgstn")
	public void setRgstn(Rgstn rgstn) {
		this.rgstn = rgstn;
	}

	public NoticeFiled getNoticefiled() {
		return noticefiled;
	}

	@XmlElement(name = "NoticeFiled")
	public void setNoticefiled(NoticeFiled noticefiled) {
		this.noticefiled = noticefiled;
	}

	public Filing getFiling() {
		return filing;
	}

	@XmlElement(name = "Filing")
	public void setFiling(Filing filing) {
		this.filing = filing;
	}

	public FormInfo getForminfo() {
		return forminfo;
	}

	@XmlElement(name = "FormInfo")
	public void setForminfo(FormInfo forminfo) {
		this.forminfo = forminfo;
	}

}
