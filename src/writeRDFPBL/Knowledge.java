package writeRDFPBL;

public class Knowledge {
	private String label;
	private String category = "";
	private String URI;
	
	
	public Knowledge(String label, String category, String uRI) {
		super();
		this.label = label;
		this.category = category;
		URI = uRI;
	}

	public Knowledge(String label, String category) {
		super();
		this.label = label;
		this.category = category;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}
	
	
}
