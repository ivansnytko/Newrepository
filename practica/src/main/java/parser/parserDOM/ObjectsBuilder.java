package parser.parserDOM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Filing;
import model.Firm;
import model.Info;
import model.MainAddr;
import model.NoticeFiled;
import model.Rgstn;
import model.States;

public class ObjectsBuilder {
	public ArrayList<Firm> firmsBuilder(Element root) throws SAXException, IOException {
		ArrayList<Firm> listFirms = new ArrayList<Firm>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Firm firm = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			firm = new Firm();
			Info info = new Info();
			Element infoElement = (Element) firmNodes.item(i).getChildNodes().item(1);
			info.setSECRgnCD(infoElement.getAttribute("SECRgnCD"));
			info.setFirmCrdNb(infoElement.getAttribute("FirmCrdNb"));
			info.setSECNb(infoElement.getAttribute("SECNb"));
			info.setBusNm(infoElement.getAttribute("BusNm"));
			info.setLegalNm(infoElement.getAttribute("LegalNm"));
			firm.setInfo(info);

			MainAddr mainaddr = new MainAddr();
			Element MainAddrElement = (Element) firmNodes.item(i).getChildNodes().item(3);
			mainaddr.setStrt1(MainAddrElement.getAttribute("Strt1"));
			mainaddr.setStrt2(MainAddrElement.getAttribute("Strt2"));
			mainaddr.setCity(MainAddrElement.getAttribute("City"));
			mainaddr.setState(MainAddrElement.getAttribute("State"));
			mainaddr.setCntry(MainAddrElement.getAttribute("Cntry"));
			mainaddr.setPostlCd(MainAddrElement.getAttribute("PostlCd"));
			mainaddr.setPhNb(MainAddrElement.getAttribute("PhNb"));
			mainaddr.setFaxNb(MainAddrElement.getAttribute("FaxNb"));
			firm.setMainaddr(mainaddr);
		
			Rgstn rgstn = new Rgstn();
			Element RgstnElement = (Element) firmNodes.item(i).getChildNodes().item(7);
			rgstn.setFirmType(RgstnElement.getAttribute("FirmType"));
			rgstn.setSt(RgstnElement.getAttribute("St"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Dt = RgstnElement.getAttribute("Dt");
			try {
				rgstn.setDt(sdf.parse(Dt));
			} catch (Exception e) {
				e.printStackTrace();
			}
			firm.setRgstn(rgstn);

			Filing filing = new Filing();
			Element FilingElement = (Element) firmNodes.item(i).getChildNodes().item(11);
			String Dt1 = FilingElement.getAttribute("Dt");
			try {
				filing.setDt(sdf.parse(Dt1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/yyyy");
			String formVrsn = FilingElement.getAttribute("FormVrsn");
			try {
				filing.setFormVrsn(sdf2.parse(formVrsn));
			} catch (Exception e) {
				e.printStackTrace();
			}
			firm.setFiling(filing);

			ArrayList<States> states = new ArrayList<States>();
			States state = null;
			NoticeFiled noticefiled = new NoticeFiled();
			Node statesNode = firmNodes.item(i).getChildNodes().item(9);
			NodeList stateslist = statesNode.getChildNodes();
			for (int j = 0; j < stateslist.getLength(); j++) {
				if (stateslist.item(j).getNodeType() == Node.ELEMENT_NODE) {
					state = new States();
					Element StatesElement = (Element) stateslist.item(j);
					state.setRgltrCd(StatesElement.getAttribute("RgltrCd"));
					state.setSt(StatesElement.getAttribute("St"));
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					String Dt3 = StatesElement.getAttribute("Dt");
					try {
						state.setDt(sdf3.parse(Dt3));
					} catch (Exception e) {
						e.printStackTrace();
					}
					states.add(state);
				}
			}
			noticefiled.setListStates(states);
			firm.setNoticefiled(noticefiled);

			listFirms.add(firm);
		}
		return listFirms;
	}
}
