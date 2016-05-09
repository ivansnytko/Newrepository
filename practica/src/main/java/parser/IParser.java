package parser;

import java.io.File;

import javax.xml.bind.JAXBException;

public interface IParser {
	 Object getObject(File file, @SuppressWarnings("rawtypes") Class c) throws JAXBException ;
	 void saveObject(File file, Object o) throws JAXBException;
}
