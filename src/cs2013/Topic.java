package cs2013;

import java.util.ArrayList;

public class Topic implements Comparable<Topic>{
    private String tipo;
    private String descricao;
    private ArrayList<Topic> subtopic = new ArrayList<Topic>();
    
	public Topic(String tipo, String descricao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public Topic() {
		super();
		this.tipo = "";
		this.descricao = "";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Topic> getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(ArrayList<Topic> subtopic) {
		this.subtopic = subtopic;
	}

	public void addSubtopic(Topic subtopic) {
		this.subtopic.add(subtopic);
	}

	@Override
	public String toString() {
		return "Topic [tipo=" + tipo + ", descricao=" + descricao + "]";
	}
	
	@Override
	public int compareTo(Topic t) {
		return this.descricao.compareTo(t.getDescricao());	}
}