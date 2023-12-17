import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

public class Sparql1 {
	public static void main(String[] args) {

		String sparqlQueryString = "PREFIX : <http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#> " +
				"SELECT ?nome {?x a :Attitude ; :attitudeName ?nome .}";
		
		Query query = QueryFactory.create(sparqlQueryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:8080/sparql", query);

		try {
			ResultSet results = qexec.execSelect();
			System.out.println("Attitudes:\n");
			for ( ; results.hasNext() ; )
			{
				QuerySolution soln = results.nextSolution() ;
				String nome = soln.get("?nome").toString();
				System.out.println(nome);
			}

		} catch(Exception e){
			System.out.println("catch error" + e.getMessage());
		}
		finally { qexec.close() ; }

	}
}
