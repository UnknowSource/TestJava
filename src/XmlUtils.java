import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class XmlUtils {
	public static int  AddXmlNode(String text,String command){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbl = dbf.newDocumentBuilder();
			Document doc = dbl.parse(RunUp.class.getClassLoader().getResourceAsStream("handler.xml"));
			Source source = new DOMSource(doc);
			Result result = new StreamResult(new FileWriter(new File("handler.xml")));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
