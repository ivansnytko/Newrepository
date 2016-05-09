package parser.jaxbParser;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter  extends XmlAdapter<String, String> {

	 @Override
	 public String unmarshal(String v) throws Exception {
	  if (v.equals("N"))
	   return "false";
	  else return "true";
	 }

	 @Override
	 public String marshal(String v) throws Exception {
	  if (v.equals("true"))
	  return "Y";
	  else
	  return "N";
	 }
}