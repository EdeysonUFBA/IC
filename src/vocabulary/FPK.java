package vocabulary;
import org.apache.jena.rdf.model.* ;

/**
 * 
 * Vocabulary for Foundational and Professional Knowledge, based on ACM/IEEE CC2020 report.
 */
public class FPK {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model m_model = ModelFactory.createDefaultModel();
    /** <p>The namespace of the vocabulary as a string ({@value})</p> */
    public static final String NS = "https://www.semanticweb.org/cc2020/fpk#";
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
	public static final Property analyticalAndCriticalThinking = m_model.createProperty(NS + "Analytical and Critical Thinking");
	public static final Property collaborationAndTeamwork =	m_model.createProperty(NS + "Collaboration and Teamwork");
	public static final Property ethicalAndInterculturalPerspectives =	m_model.createProperty(NS + "Ethical and Intercultural Perspectives");
	public static final Property mathematicsAndStatistics =	m_model.createProperty(NS + "Mathematics and Statistics");
	public static final Property multiTaskPrioritizationAndManagement =	m_model.createProperty(NS + "Multi-Task Prioritization and Management");
	public static final Property oralCommunicationAndPresentation =	m_model.createProperty(NS + "Oral Communication and Presentation");
	public static final Property problemSolvingAndTroubleShooting =	m_model.createProperty(NS + "Problem Solving and Trouble Shooting");
	public static final Property projectAndTaskOrganizationAndPlanning =	m_model.createProperty(NS + "Project and Task Organization and Planning");
	public static final Property qualityAssuranceControl =	m_model.createProperty(NS + "Quality Assurance / Control");
	public static final Property relationshipManagement =	m_model.createProperty(NS + "Relationship Management");
	public static final Property researchAndSelfStarterLearner =	m_model.createProperty(NS + "Research and Self-Starter/Learner");
	public static final Property timeManagement =	m_model.createProperty(NS + "Time Management");
	public static final Property writtenCommunication =	m_model.createProperty(NS + "Written Communication");
	
	public static final Property category = m_model.createProperty(NS + "category" );
	public static final Property label = m_model.createProperty(NS + "label" );	
}

