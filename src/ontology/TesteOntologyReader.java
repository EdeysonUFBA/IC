package ontology;

public class TesteOntologyReader {

	public static void main(String[] args) {
		String ontologyFile = "C:\\Users\\edeys\\Meu Drive (edeysongomes@ufba.br)\\Doutorado\\Projetos\\Ontologia CHA\\CompetenciasKSA.ttl";
		String uri = "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias";

		try {
			OntologyReader or = new OntologyReader(uri, ontologyFile);
			//or.testNewInstance();
			//or.showOntologyData();
			
			/** Exibe as Classes da Ontologia sem e com filtro. */
			or.listClasses();
			//or.listClasses(uri);
			
			/** Exibe as propriedades da Ontologia sem e com filtro. */
			//or.listProperties();
			//or.listProperties(uri);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
