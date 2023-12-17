package writeRDFPBL;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import vocabulary.CCS2012;
import vocabulary.FPK;
import vocabulary.LOMC;

public class testTaskRDFWriterIMC {
    static String lomvoc = "http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#";
	static String resourceURI = "https://eduknow.org/IMC.md";
	
	public static void main(String[] args) {
		Task task = criaTaskIMC();
		TaskRDFWriter rdfWriter = new TaskRDFWriter(task, resourceURI);
		
		RDFDataMgr.write(System.out, rdfWriter.getModel(), Lang.RDFXML);
	}
	
	private static Task criaTaskIMC() {
		Task task = new Task();
		
		task.setTitle("Problema : Calcular o Índice de Massa Corporal de um indivíduo.");
		
		task.setType("learningObject");
		task.setOtherPlatformRequirements("Editor de texto");
		task.setAggregationLevel(lomvoc + "AggregationLeve-l");
		task.setCopyright("http://creativecommons.org/licenses/by-nc-nd/3.0/");
		task.setCost("no");
		task.addKeyword("IMC");
		task.addKeyword("Programação");
		task.addKeyword("Algotirmo");	
		task.setMetaMetadataLanguage("pt");
		task.setStructure(lomvoc + "Structure-atomic");
		task.setLanguage("pt");

		task.addAuthor(new Author("Laís Salvador", "http://www.ufba.br", "laisns@ufba.br") );
		task.addAuthor(new Author("Edeyson Gomes", "http://www.ufba.br", "edeysongomes@ufba.br") );		
		task.addAuthor(new Author("Jéssica Santana", "http://www.ufba.br", "jessicasantana@ufba.br") );		
		task.setCreationDate("2022/09/21");

		task.addContributor("Luiz Gavaza");
		
	 	task.setEducationalContext("higher education");
	   	task.setLearningResourceType("problem statement");  
	   	task.setEducationalDescription("Competency Description"); 
        
	   	/** Competências **/
		Competency c = new Competency();
		
		c = new Competency();
		c.setStatement("Codificar, em grupo, uma tarefa simples numa linguagem de programação.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));		
		c.addDisposition(new Disposition("Proativo"));
		c.setUri("C1");
		c.setType(LOMC.AtomicCompetence);		
		
		Knowledge k = new Knowledge("General_programming_languages", "10011007.10011006.10011008", CCS2012.NS);
		Skill skill = new Skill("Applying");
		KnowledgeSkill ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Programming_logic", "10003752.10003790.10003806", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS02");		
		c.addKnowledgeSkill(ks);		
		
		k = new Knowledge("Requirements_analysis", "10011007.10011074.10011075.10011076", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS03");		
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);

		
		c = new Competency();
		c.setStatement("Aplicar cálculos de frações e exponenciação.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));		
		c.setUri("C2");
		c.setType(LOMC.AtomicCompetence);	
		
		k = new Knowledge("Mathematics_and_Statistics", "", FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C2KS01");
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);
		
				
		c = new Competency();
		c.setStatement("Desenvolver, em grupo, uma interface simples para interação com usuários.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));
		c.setUri("C3");
		c.setType(LOMC.AtomicCompetence);		
		
		k = new Knowledge("Human_computer_interaction", "10003120.10003121", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C3KS01");		
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);		
		
		
		c = new Competency();		
		c.setStatement("Escrever, em grupo, um relatório técnico.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Inventivo"));		
		c.setUri("C4");
		c.setType(LOMC.AtomicCompetence);
		
		k = new Knowledge("Written_Communication", "", FPK.NS);
		skill = new Skill("Creating");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C4KS01");
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);
		
		return task;
	}

}
