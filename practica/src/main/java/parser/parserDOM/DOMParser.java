package parser.parserDOM;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import model.Firm;
import model.Firms;
import model.IAPDFirmSECReport;
import parser.IParser;

public class DOMParser implements IParser {
	public static Logger log = Logger.getLogger(DOMParser.class.getName());

	public Object getObject(File file, @SuppressWarnings("rawtypes") Class c) throws JAXBException {
		IAPDFirmSECReport iAPDFirmSECReport = new IAPDFirmSECReport();
		Firms firms1 = new Firms();
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document document = db.parse(file);

			Element root = document.getDocumentElement();
			ObjectsBuilder ob = new ObjectsBuilder();

			ArrayList<Firm> firms = ob.firmsBuilder(root);
			firms1.setListFirms(firms);
			iAPDFirmSECReport.setFirms(firms1);
		} catch (SAXException e) {
			log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}
		return iAPDFirmSECReport;

	}

	public void saveObject(File file, Object o) throws JAXBException {
	}
}