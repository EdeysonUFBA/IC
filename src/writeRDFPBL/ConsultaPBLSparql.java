package writeRDFPBL;


import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

public class ConsultaPBLSparql {

	static final String inputFileName = "PBL.xml";

	public static void main(String[] args) {
		consulta1();
	}

	public static void consulta1() {
		String NS_LOMC = "http://eduknow.org/Competencias#";
		String queryStr =
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
						"PREFIX cc2012: <http://www.acm.org/about/class/2012#>\n" +
						"PREFIX lomc: <" + NS_LOMC + ">\n" +
						"SELECT ?knowledgeName ?skill \n" +
						"WHERE {\n" +
						"  ?atomic rdf:type lomc:AtomicCompetence .\n" +
						"  ?atomic lomc:knowledgeSkill ?ks .\n" +
						"  ?ks lomc:skill ?skill .\n" +
						"  ?ks lomc:knowledge ?knowledge .\n" +
						"  ?knowledge cc2012:category ?category .\n" +
						"  ?knowledge cc2012:label ?knowledgeName .\n" +
						"}";

		Model model = ModelFactory.createDefaultModel();
		model.read("PBL.xml");
		Query query = QueryFactory.create(queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			//String atomic = soln.getResource("atomic").getLocalName();
			String skill = soln.getResource("skill").getLocalName();
			//String knowledge = soln.getResource("knowledge").getLocalName();
			String category = soln.getLiteral("knowledgeName").getString();
			//String label = soln.getLiteral("label").getString();
			System.out.printf("\nKnowledge: %s\t  Skill: %s", category, skill);
		}
		qe.close();
	}

	
	public static void consulta3() {
		String NS_LOMC = "http://eduknow.org/Competencias#";
		String queryStr =
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
						"PREFIX cc2012: <http://www.acm.org/about/class/2012#>\n" +
						"PREFIX lomc: <" + NS_LOMC + ">\n" +
						"SELECT ?atomic ?knowledge ?skill ?category ?label\n" +
						"WHERE {\n" +
						"  ?atomic rdf:type lomc:AtomicCompetence .\n" +
						"  ?atomic lomc:knowledgeSkill ?ks .\n" +
						"  ?ks lomc:skill ?skill .\n" +
						"  ?ks lomc:knowledge ?knowledge .\n" +
						"  ?knowledge cc2012:category ?category .\n" +
						"  ?knowledge cc2012:label ?label .\n" +
						"}";

		Model model = ModelFactory.createDefaultModel();
		model.read("PBL.xml");
		Query query = QueryFactory.create(queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			String atomic = soln.getResource("atomic").getLocalName();
			String skill = soln.getResource("skill").getLocalName();
			String knowledge = soln.getResource("knowledge").getLocalName();
			String category = soln.getLiteral("category").getString();
			String label = soln.getLiteral("label").getString();
			System.out.printf("\nAtomic: %s\n\t  Skill: %s\n\t  Knowledge: %s\n\t\t  Category: %s\n\t\t  Label: %s\n",
					atomic, skill, "", category, label);
		}
		qe.close();
	}

}


