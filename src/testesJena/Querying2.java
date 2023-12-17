package testesJena;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Querying2 {
	static final String inputFileName = "vc-db-1.rdf";
	static final String johnSmithURI = "http://somewhere/JohnSmith";

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		model.read(inputFileName);

		StmtIterator iter = model.listStatements(
			    new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
			        public boolean selects(Statement s)
			            {return s.getString().endsWith("Smith");}
			    });
		
		while (iter.hasNext()) {
		    Statement s = iter.nextStatement();
		    System.out.println(s.getString());
		}
	}
}
