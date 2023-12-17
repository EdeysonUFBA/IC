package testesJena;

import java.io.PrintWriter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

public class Teste05 {
    public static void main (String args[]) {
        // create an empty graph
        Model model = ModelFactory.createDefaultModel();

       // create the resource
       Resource r = model.createResource();                                     

      // add the property
      r.addProperty(RDFS.label, model.createLiteral("chat", "en"))
       .addProperty(RDFS.label, model.createLiteral("chat", "fr"))
       .addProperty(RDFS.label, model.createLiteral("<em>chat</em>", true));
      
      // write out the graph
      model.write(new PrintWriter(System.out));
      System.out.println();
      
      // create an empty graph
      model = ModelFactory.createDefaultModel();

       // create the resource
       r = model.createResource();                                     

      // add the property
      r.addProperty(RDFS.label, "11")
       .addLiteral(RDFS.label, 11);
      
      // write out the graph
      model.write( System.out, "N-TRIPLE");
      }
}
