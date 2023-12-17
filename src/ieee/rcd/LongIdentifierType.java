package ieee.rcd;

public class LongIdentifierType {
	public String catalog;
	public String entry;
	
	public LongIdentifierType(String catalog, String entry) {
		super();
		this.catalog = catalog;
		this.entry = entry;
	}
	
	public String getCatalog() {
		return catalog;
	}
	
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "LongIdentifierType [catalog=" + catalog + ", entry=" + entry + "]";
	}
	
	
}
