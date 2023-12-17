import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

public class Sparql3 {
	public static void main(String[] args) {

		String sparqlQueryString = "PREFIX : <http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#> " +
				"SELECT ?skill ?level ?description { ?skill a :Skill; " +
				":skillLevel ?level; :skillDescription ?description.}";
		
		Query query = QueryFactory.create(sparqlQueryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:8080/sparql", query);

		try {
			ResultSet results = qexec.execSelect();
			System.out.println("Skills:\n");
			for ( ; results.hasNext() ; )
			{
				QuerySolution soln = results.nextSolution() ;
				
				String skill = soln.get("?skill").toString();
				//String level = soln.get("?level").toString();
				int level = soln.getLiteral("?level").getInt();
				String description = soln.get("?description").toString();
				System.out.println(level + " - " + description);
			}

		} catch(Exception e){
			System.out.println("catch error" + e.getMessage());
		}
		finally { qexec.close() ; }

	}
}
