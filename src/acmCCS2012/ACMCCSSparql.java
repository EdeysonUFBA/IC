package acmCCS2012;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

public class ACMCCSSparql {
	
	public static void main(String[] args) {
		String URI = "file:///C:/Projetos/EduKnow/JenaKSA/";
		//queryByLabel("Written Communication");
		//queryByCategory(URI + "10002951.10002952");
		//selectAllConcepts();
		topConcepts();
	}

	private static void queryACMCCS2021(String queryStatement) {
		OntModel ontology = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		ontology.read("acm_ccs2012.xml");

		Query query = QueryFactory.create(queryStatement);
		QueryExecution qe = QueryExecutionFactory.create(query, ontology);
		ResultSet result = qe.execSelect();

		while (result.hasNext()) {
		    QuerySolution solution = result.next();
		    RDFNode category = solution.get("category");
		    RDFNode label = solution.get("label");
		    String code = clearPrefix(category.toString(), '/');
		    //System.out.println("Concept: " + code + " - Label: " + clearSuffix(label.toString(), '@'));
		    System.out.println("Category: " + category + " - Label: " + label);
		}

		qe.close();
	}
	
	private static void selectAllConcepts() {
		String queryStatement = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
								"SELECT ?category ?label 							\n"	+
								"WHERE { ?category skos:prefLabel ?label }";
		
		queryACMCCS2021(queryStatement);
	}
	
	private static void topConcepts() {
		String queryStatement = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
								"SELECT ?category ?label						\n"		+
								"WHERE {										\n"		+
								"  ?category skos:topConceptOf <ccs2012>.		\n" 	+
								"  ?category skos:prefLabel ?label.				\n"		+
								"  FILTER(langMatches(lang(?label), \"en\"))	\n"		+
								"}";

		
		queryACMCCS2021(queryStatement);
	}
	
	private static void queryByLabel(String label) {
		String queryStatement = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\n" +
								"SELECT ?category ?label 						\n"		+ 
								"WHERE {?category skos:prefLabel ?label.		\n"		+
								"  FILTER(str(?label) = '" + label + "')\n"		+ 
								"}";
		
		queryACMCCS2021(queryStatement);		
	}
	
	private static void queryByCategory(String category) {
		String queryStatement = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\n" +
								"SELECT ?category ?label 						\n"		+ 
								"WHERE {?category skos:prefLabel ?label.		\n"		+
								"  FILTER(str(?category) = '" + category + "')\n"		+ 
								"}";
		

		queryACMCCS2021(queryStatement);		
	}	
	


	private static String clearPrefix(String s, char prefixDelimiter) {
		int pos = s.lastIndexOf(prefixDelimiter);

		if (pos > 0) {
			s = s.substring(pos+1);
		}
		return s;
	}
	
	private static String clearSuffix(String s, char suffixDelimiter) {
		int pos = s.lastIndexOf(suffixDelimiter);

		if (pos > 0) {
			s = s.substring(0, pos);
		}
		return s;
	}	


}
