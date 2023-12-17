package writeRDFPBL;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Author {
	private String fullName;
	private String organization;
	private String email;
	
	
	public Author(String fullName, String organization, String email) {
		super();
		this.fullName = fullName;
		this.organization = organization;
		this.email = email;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [fullName=" + fullName + ", organization=" + organization + ", email=" + email + "]";
	}
	
	
}
