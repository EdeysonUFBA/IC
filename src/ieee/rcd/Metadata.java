package ieee.rcd;

public class Metadata {
	private String rcdSchema = "ieee.org/1484.20.1/2007";
	private String rcdSchemaVersion = "1.0";
	private Object additionalMetadata;
	
	public Metadata(String rcdSchema, String rcdSchemaVersion, Object additionalMetadata) {
		super();
		this.rcdSchema = rcdSchema;
		this.rcdSchemaVersion = rcdSchemaVersion;
		this.additionalMetadata = additionalMetadata;
	}

	public Metadata(String rcdSchema, String rcdSchemaVersion) {
		super();
		this.rcdSchema = rcdSchema;
		this.rcdSchemaVersion = rcdSchemaVersion;
	}

	public Metadata(String rcdSchema) {
		super();
		this.rcdSchema = rcdSchema;
	}

	public String getRcdSchema() {
		return rcdSchema;
	}

	public void setRcdSchema(String rcdSchema) {
		this.rcdSchema = rcdSchema;
	}

	public String getRcdSchemaVersion() {
		return rcdSchemaVersion;
	}

	public void setRcdSchemaVersion(String rcdSchemaVersion) {
		this.rcdSchemaVersion = rcdSchemaVersion;
	}

	public Object getAdditionalMetadata() {
		return additionalMetadata;
	}

	public void setAdditionalMetadata(Object additionalMetadata) {
		this.additionalMetadata = additionalMetadata;
	}
}
