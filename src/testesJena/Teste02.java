package testesJena;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Teste02 {
	 static final String inputFileName  = "vc-db-1.rdf";
     
	    public static void main (String args[]) {
	        Model model = ModelFactory.createDefaultModel();

	        InputStream in = FileManager.get().open( inputFileName );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
	        }
	        
	        model.read(in, "");
	                    
	        model.write(System.out);            
	    }
}
