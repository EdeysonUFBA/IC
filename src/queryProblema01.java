import java.io.InputStream;

import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class queryProblema01 {
	
	static final String inputFileName  = "C:\\Projetos\\EduKnow\\RepoPBL\\MaquinaSalgados\\Problema01Competencias.rdf";	
	static final String git = "https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md#";
		
	public static void main(String[] args) {

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }
        
        model.read(in, "");		

//		String sparqlQueryString = "PREFIX : <http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#> " +
//		                           "PREFIX git: <https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md#> " +
//				"SELECT ?comp {?comp a :AtomicCompetence. }";

		String sparqlQueryString = "PREFIX : <http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#> " +
					"SELECT ?competence ?knowledge ?skill	WHERE { " + 
						"?competence :atomicCompetenceHasKnowledgeSkill ?knowledgeSkill . " +
						"?knowledgeSkill :knowledgeSkillHasKnowledge ?knowledge . " +
						"?knowledgeSkill :knowledgeSkillHasSkill ?skill. } ";
		
		Query query = QueryFactory.create(sparqlQueryString);

		query.serialize(new IndentedWriter(System.out,true)) ;
		System.out.println() ;

		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		try {
			ResultSet results = qexec.execSelect();
			System.out.println("=== KSA === \n");
			for ( ; results.hasNext() ; )
			{
				QuerySolution soln = results.nextSolution() ;
				String comp = soln.get("?competence").toString();
				String knowledge = soln.get("?knowledge").toString();	
				String skill = soln.get("?skill").toString();					
				System.out.println("Competence: " + removePrefixo(comp));
				System.out.println("   -> Knowledge: " + removePrefixo(knowledge));
				System.out.println("         -> Skill: " + removePrefixo(skill));
			}

		} catch(Exception e){
			System.out.println("catch error" + e.getMessage());
		}
		finally { qexec.close() ; }
	}
	
	private static String removePrefixo(String s) {
		int pos = s.lastIndexOf("#");
		if (pos > 0)
			s = s.substring(pos+1);
		s = s.replace('_', ' ');
		return s;
	}
}
