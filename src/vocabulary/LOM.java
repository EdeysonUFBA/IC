package vocabulary;
import org.apache.jena.rdf.model.* ;

public class LOM {

    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string ({@value})</p> */
    public static final String NS = "http://ltsc.ieee.org/rdf/lomv1p0/lom#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
	public static final Resource Educational    = m_model.createProperty(NS + "Educational");
	
	public static final Property learningObject = m_model.createProperty(NS + "learningObject" );
	public static final Property otherPlatformRequirements = m_model.createProperty(NS + "otherPlatformRequirements" );
	public static final Property aggregationLevel = m_model.createProperty(NS + "aggregationLevel" );
	public static final Property copyrightAndOtherRestrictions = m_model.createProperty(NS + "copyrightAndOtherRestrictions" );
	public static final Property cost = m_model.createProperty(NS + "cost" );
	public static final Property keyword = m_model.createProperty(NS + "keyword" );
	public static final Property metaMetadataLanguage = m_model.createProperty(NS + "metaMetadataLanguage" );
	public static final Property structure = m_model.createProperty(NS + "structure" );
	public static final Property version = m_model.createProperty(NS + "version");
	public static final Property status = m_model.createProperty(NS + "status");
	public static final Property contribute = m_model.createProperty(NS + "contribute");
	public static final Property metadataScheme = m_model.createProperty(NS + "metadataScheme");
	public static final Property location = m_model.createProperty(NS + "location");
	public static final Property requirements = m_model.createProperty(NS + "requirements");
	public static final Property installationRemarks = m_model.createProperty(NS + "installationRemarks");
	public static final Property interactivityType = m_model.createProperty(NS + "interactivityType");
	public static final Property interactivityLevel = m_model.createProperty(NS + "interactivityLevel");
	public static final Property semanticDensity = m_model.createProperty(NS + "semanticDensity");
	public static final Property intendedEndUserRole = m_model.createProperty(NS + "intendedEndUserRole");
	public static final Property context = m_model.createProperty(NS + "context");
	public static final Property typicalAgeRange = m_model.createProperty(NS + "typicalAgeRange");
	public static final Property difficulty = m_model.createProperty(NS + "difficulty");
	public static final Property educationalDescription = m_model.createProperty(NS + "educationalDescription");
	public static final Property learningResourceType = m_model.createProperty(NS + "learningResourceType");
	public static final Property educationalLanguage = m_model.createProperty(NS + "educationalLanguage");
	public static final Property educationalContext  = m_model.createProperty(NS + "educationalContext");
	public static final Property annotation = m_model.createProperty(NS + "annotation");
	public static final Property classification = m_model.createProperty(NS + "classification");
	public static final Property role = m_model.createProperty(NS + "role");
	public static final Property entity = m_model.createProperty(NS + "entity");
	public static final Property alternative = m_model.createProperty(NS + "alternative");
	public static final Property technology  = m_model.createProperty(NS + "technology ");
	public static final Property minimumVersion = m_model.createProperty(NS + "minimumVersion");
	public static final Property maximumVersion = m_model.createProperty(NS + "maximumVersion");
	public static final Property purpose = m_model.createProperty(NS + "alternative");
	public static final Property taxon = m_model.createProperty(NS + "taxon");
}

