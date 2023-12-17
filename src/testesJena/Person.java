package testesJena;

public class Person {
	private String firstName;
	private String familyName;
	private String fullName;
	private String email;
	private String uri;

	public Person(String firstName, String familyName, String uri) {
		super();
		this.firstName = firstName;
		this.familyName = familyName;
		this.fullName = firstName + " " + familyName;
		this.uri = uri;
	}

	public Person(String firstName, String familyName, String email, String uri) {
		super();
		this.firstName = firstName;
		this.familyName = familyName;
		this.email = email;
		this.uri = uri;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


}
