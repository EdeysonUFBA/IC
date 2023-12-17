package cs2013;

public class LearningOutcome {
    private String tipo;
    private String descrição;
    private String mastery;
    
	public LearningOutcome(String tipo, String descrição, String mastery) {
		super();
		this.tipo = tipo;
		this.descrição = descrição;
		this.mastery = mastery;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getMastery() {
		return mastery;
	}

	public void setMastery(String mastery) {
		this.mastery = mastery;
	}

	@Override
	public String toString() {
		return "LearningOutcome [tipo=" + tipo + ", descrição=" + descrição + ", mastery=" + mastery + "]";
	}


}
