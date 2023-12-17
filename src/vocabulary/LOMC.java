package vocabulary;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

public class LOMC {
	//public static final String NS = "http://www.semanticweb.org/edeyson/ontologies/2023/Competencias#";
	public static final String NS = "http://eduknow.org/Competencias#";
	private static final Model m_model = ModelFactory.createDefaultModel();	
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
	public static final Resource Competence = m_model.createProperty(NS + "Competence" );
	public static final Resource AtomicCompetence = m_model.createProperty(NS + "AtomicCompetence");	
	public static final Resource Disposition = m_model.createProperty(NS + "Disposition");
	public static final Resource KnowledgeSkill = m_model.createProperty(NS + "KnowledgeSkill");	
	public static final Resource Knowledge = m_model.createProperty(NS + "Knowledge");
	public static final Resource Skill = m_model.createProperty(NS + "Skill");

	public static final Property educationalCompetency    = m_model.createProperty(NS + "educationalCompetency" ); 

	public static final Property hasCompetence = m_model.createProperty(NS + "competence" );
	public static final Property hasDisposition = m_model.createProperty(NS + "disposition" );
	public static final Property hasKnowledgeSkill = m_model.createProperty(NS + "knowledgeSkill" );	
	public static final Property hasKnowledge = m_model.createProperty(NS + "knowledge" );
	public static final Property knowledgeLabel = m_model.createProperty(NS + "knowledgeLabel" );
	public static final Property knowledgeCode = m_model.createProperty(NS + "knowledgeCode" );	
	public static final Property hasSkill = m_model.createProperty(NS + "skill" );
	
	public static final Property competenceStatement = m_model.createProperty(NS + "competenceStatement" );
	
	public static final Property taskAchievesCompetence = m_model.createProperty(NS + "taskAchievesCompetence" );	

	public static final Resource Remembering = m_model.createProperty(NS + "Remembering");
	public static final Resource Understanding = m_model.createProperty(NS + "Understanding");
	public static final Resource Applying = m_model.createProperty(NS + "Applying");	
	public static final Resource Analyzing = m_model.createProperty(NS + "Analyzing");
	public static final Resource Evaluating = m_model.createProperty(NS + "Evaluating");
	public static final Resource Creating = m_model.createProperty(NS + "Creating");
	
	public static final Resource Task = m_model.createProperty(NS + "Task");
}
