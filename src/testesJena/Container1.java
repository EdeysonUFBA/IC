package testesJena;

import java.io.PrintWriter;

import org.apache.jena.rdf.model.Bag;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class Container1 {
	static final String inputFileName = "vc-db-1.rdf";

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		model.read(inputFileName) ;
		
		StmtIterator iter = model.listStatements(
				new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
					public boolean selects(Statement s) {
						return s.getString().endsWith("Smith");
					}
				});
		
		Bag smiths = model.createBag();
		while (iter.hasNext()) {
			smiths.add(iter.nextStatement().getSubject());
		}

        // print the graph as RDF/XML
        model.write(new PrintWriter(System.out));
        System.out.println();   
        
        // print out the members of the bag
        NodeIterator iter2 = smiths.iterator();
        if (iter2.hasNext()) {
            System.out.println("The bag contains:");
            while (iter2.hasNext()) {
                System.out.println("  " +
                    ((Resource) iter2.next())
                                     .getRequiredProperty(VCARD.FN)
                                     .getString());
            }
        } else {
            System.out.println("The bag is empty");
        }        
	}
}
