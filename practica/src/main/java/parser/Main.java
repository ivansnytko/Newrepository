package parser;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import dao.myBatis.Select;
import model.Firm;
import model.IAPDFirmSECReport;
import parser.jaxbParser.JaxbParser;
import parser.parserDOM.DOMParser;
import dao.dao.*;


public class Main {
	public static void main(String[] args) throws IOException, SQLException {
		try {
			
			ArrayList<Firm> listfirm = new ArrayList<Firm>();
			
			File file = new File("src//main/resources/test_ng_full.xml");
			//JaxbParser parser = new JaxbParser();
			DOMParser parser = new DOMParser();
			IAPDFirmSECReport iAPDFirmSECReport = (IAPDFirmSECReport) parser.getObject(file, IAPDFirmSECReport.class);
			int a = 50;
			listfirm = iAPDFirmSECReport.getFirms().getListFirms();
			//dao import dao.dao.*;
			InfoImpl insertinfo = new InfoImpl();		
			insertinfo.insertInfo(listfirm,a, null);
			MainAddrImpl insertMainAddr = new MainAddrImpl();
			insertMainAddr.insertMainAddr(listfirm, a, null);
			FilingImpl insertFiling = new FilingImpl();
			insertFiling.insertFiling(listfirm, a, null);
			RgstnImpl insertRgstn = new RgstnImpl();
			insertRgstn.insertRgstn(listfirm, a, null);
			StatesImpl insertStates = new StatesImpl();
			insertStates.insertStates(listfirm, a, null);
			Select selectinfo = new Select();
			selectinfo.selectInfo();
			selectinfo.selectAllById();
			
			
			//import dao.myBatis.*;
			/*InfoImpl infoImpl = new InfoImpl();
			MainAddrImpl mainAddrImpl = new MainAddrImpl();
			FilingImpl filingImpl = new FilingImpl();
			RgstnImpl rgstnImpl = new RgstnImpl();
			StatesImpl statesImpl = new StatesImpl();	
			for (int i = 0; i<a; i++){
				infoImpl.insertInfo(listfirm, a, listfirm.get(i).getInfo());
				listfirm.get(i).getMainaddr().setInfo_id(listfirm.get(i).getInfo().getInfo_id());
				listfirm.get(i).getFiling().setInfo_id(listfirm.get(i).getInfo().getInfo_id());
				listfirm.get(i).getRgstn().setInfo_id(listfirm.get(i).getInfo().getInfo_id());
				mainAddrImpl.insertMainAddr(listfirm, a, listfirm.get(i).getMainaddr());
				filingImpl.insertFiling(listfirm, a, listfirm.get(i).getFiling());
				rgstnImpl.insertRgstn(listfirm, a, listfirm.get(i).getRgstn());
				for(int j = 0; j< listfirm.get(i).getNoticefiled().getListStates().size(); j++ ){
					listfirm.get(i).getNoticefiled().getListStates().get(j).setInfoid(listfirm.get(i).getInfo().getInfo_id());
					statesImpl.insertStates(listfirm, a, listfirm.get(i).getNoticefiled().getListStates().get(j));
				}	
			}
			Select selectinfo = new Select();
			selectinfo.selectInfo();
			selectinfo.selectAllById();*/
		} catch (JAXBException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}