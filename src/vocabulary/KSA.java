package vocabulary;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

public class KSA {

    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string ({@value})</p> */
    public static final String NS = "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    

	public static final Resource Competence = m_model.createProperty(NS + "Competence" );
	public static final Resource AtomicCompetence = m_model.createProperty(NS + "AtomicCompetence");	
	public static final Resource ComposedCompetence = m_model.createProperty(NS + "ComposedCompetence");	

	public static final Resource Disposition = m_model.createProperty(NS + "Disposition");
	public static final Resource CognitiveActionVerbs = m_model.createProperty(NS + "CognitiveActionVerbs");	
	
	public static final Resource Knowledge = m_model.createProperty(NS + "Knowledge");
	public static final Resource ComputingKnowledge = m_model.createProperty(NS + "ComputingKnowledge");	
	public static final Resource Skill = m_model.createProperty(NS + "Skill");
	public static final Resource KnowledgeSkill = m_model.createProperty(NS + "KnowledgeSkill");	
	
	public static final Resource BloomCognitiveSkill = m_model.createProperty(NS + "BloomCognitiveSkill");
	public static final Resource Remembering = m_model.createProperty(NS + "Remembering");
	public static final Resource Understanding = m_model.createProperty(NS + "Understanding");
	public static final Resource Applying = m_model.createProperty(NS + "Applying");	
	public static final Resource Analyzing = m_model.createProperty(NS + "Analyzing");
	public static final Resource Evaluating = m_model.createProperty(NS + "Evaluating");
	public static final Resource Creating = m_model.createProperty(NS + "Creating");
	
	public static final Resource Task = m_model.createProperty(NS + "Task");
	
	public static final Property hasAtomicCompetence = m_model.createProperty(NS + "hasAtomicCompetence" );
	public static final Property hasDisposition = m_model.createProperty(NS + "hasDisposition" );

	public static final Property hasCognitiveActionVerbs = m_model.createProperty(NS + "hasCognitiveActionVerbs" );
	public static final Property hasCompetence = m_model.createProperty(NS + "hasCompetence" );
	public static final Property hasKnowledge = m_model.createProperty(NS + "hasKnowledge" );
	public static final Property hasSkill = m_model.createProperty(NS + "hasSkill" );
	public static final Property hasKnowledgeSkill = m_model.createProperty(NS + "hasKnowledgeSkill" );	
	
	public static final Property attitudeName  = m_model.createProperty(NS + "name" );	
	public static final Property competenceStatement = m_model.createProperty(NS + "statement" );	
	public static final Property competenceTitle = m_model.createProperty(NS + "title" );	
	public static final Property knowledgeArea = m_model.createProperty(NS + "area" );	
	public static final Property knowledgeCategory = m_model.createProperty(NS + "category");	
	public static final Property skillDescription = m_model.createProperty(NS + "explanation" );	
	public static final Property skillLevel = m_model.createProperty(NS + "level" );	
	public static final Property taskDescription = m_model.createProperty(NS + "description" );	
	public static final Property verb = m_model.createProperty(NS + "verb" );	
}

