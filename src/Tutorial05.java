
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/** Tutorial 5 - read RDF XML from a file and write it to standard out
 */
public class Tutorial05 extends Object {

    /**
        NOTE that the file is loaded from the class-path and so requires that
        the data-directory, as well as the directory containing the compiled
        class, must be added to the class-path when running this and
        subsequent examples.
    */    
    static final String inputFileName  = "vc-db-1.rdf";
                              
    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        try {
        	//read the RDF/XML file
	        model.read( inputFileName );
	        //write the model content
	        model.write(System.out);
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
