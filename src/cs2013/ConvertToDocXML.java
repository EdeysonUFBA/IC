package cs2013;

import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class ConvertToDocXML {
	
	public static void main(String[] args) {
        BoKCS2013Parser bok2013 = new BoKCS2013Parser();
        ArrayList<KnowledgeArea> areas = bok2013.getBoKCS2013();

        try {
            Document xmlDoc = XMLConverter.convertToXML(areas);

          
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlDoc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Pc\\Downloads\\output.xml"));
            transformer.transform(source, result);

            System.out.println("Arquivo XML criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
