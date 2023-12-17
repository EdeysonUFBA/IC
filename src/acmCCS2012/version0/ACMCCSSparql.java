package acmCCS2012.version0;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

public class ACMCCSSparql {
	
	public static void main(String[] args) {
		//queryACMCCS2021();
		queryACMCCS2021ByLabel("Data management systems");
	}

	private static void queryACMCCS2021() {
		// Carrega o arquivo XML da ontologia RDF da ACM CCS
		OntModel ontology = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		ontology.read("acm_ccs2012.xml");

		/** All Concepts */
		String queryStatement = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
							"SELECT ?category ?label WHERE { ?category skos:prefLabel ?label }";

		/** Top Concepts */
/*		String queryStatement = " 		PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\n"
				+ "		SELECT ?category ?label\r\n"
				+ "		WHERE {\r\n"
				+ "		  ?category skos:topConceptOf <ccs2012>.\r\n"
				+ "		  ?category skos:prefLabel ?label.\r\n"
				+ "		  FILTER(langMatches(lang(?label), \"en\"))\r\n"
				+ "		}";
*/
		
		// Executa a consulta
		Query query = QueryFactory.create(queryStatement);
		QueryExecution qe = QueryExecutionFactory.create(query, ontology);
		ResultSet resultados = qe.execSelect();

		// Processa os resultados
		while (resultados.hasNext()) {
		    QuerySolution solucao = resultados.next();
		    RDFNode category = solucao.get("category");
		    RDFNode label = solucao.get("label");
		    System.out.println(category + " - " + label);
		}

		// Fecha a consulta
		qe.close();
	}

	private static void queryACMCCS2021ByLabel(String categoryLabel) {
		// Carrega o arquivo XML da ontologia RDF da ACM CCS
		OntModel ontology = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		ontology.read("acm_ccs2012.xml");

		/** Specific Concept */
		String queryStatement = " 		PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\n"
				+ "		SELECT ?category ?label \r\n"
				+ "		WHERE {?category skos:prefLabel ?label.\r\n"
				+ "		  FILTER(str(?label) = '" + categoryLabel + "')\r\n"
				+ "		}";
		//System.out.println(queryStatement);
		
		// Executa a consulta
		Query query = QueryFactory.create(queryStatement);
		QueryExecution qe = QueryExecutionFactory.create(query, ontology);
		ResultSet result = qe.execSelect();

		// Processa os resultados
		while (result.hasNext()) {
		    QuerySolution solucao = result.next();
		    RDFNode category = solucao.get("category");
		    RDFNode label = solucao.get("label");
		    String code = clearSuffix(category.toString(), '/');
		    System.out.println(code + " - " + label);
		}

		// Fecha a consulta
		qe.close();
	}

	private static String clearSuffix(String s, char suffixDelimiter) {
		int pos = s.lastIndexOf(suffixDelimiter);

		if (pos > 0) {
			s = s.substring(pos+1);
		}
		return s;
	}


}
