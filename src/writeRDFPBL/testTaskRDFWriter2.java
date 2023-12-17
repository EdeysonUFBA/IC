package writeRDFPBL;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import vocabulary.CCS2012;
import vocabulary.FPK;
import vocabulary.LOMC;

public class testTaskRDFWriter2 {
    static String lomvoc = "http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#";
	static String resourceURI = "https://eduknow.org/MAQ.md";
	
	public static void main(String[] args) {
		Task task = criaTaskTuringMachineI();
		TaskRDFWriter rdfWriter = new TaskRDFWriter(task, resourceURI);
		
		RDFDataMgr.write(System.out, rdfWriter.getModel(), Lang.RDFXML);
	}
	
	private static Task criaTaskTuringMachineI() {
		Task task = new Task();
		
		task.setTitle("Problema : A máquina de vender refrigerantes e salgados.");
		
		task.setType("learningObject");
		task.setOtherPlatformRequirements("Editor de texto");
		task.setAggregationLevel(lomvoc + "AggregationLeve-l");
		task.setCopyright("http://creativecommons.org/licenses/by-nc-nd/3.0/");
		task.setCost("no");
		
		task.addKeyword("Sistema Autômato");
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
        
		Competency c = new Competency();
		c.setStatement("Desenvolver soluções de problemas usando Autômatos.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Investigativo"));
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Proativo"));
		c.addDisposition(new Disposition("Criativo"));
		c.setUri("C1");
		c.setType(LOMC.AtomicCompetence);
		
		Knowledge k = new Knowledge("Finite_state_machines","", CCS2012.NS);
		Skill skill = new Skill("Applying");
		KnowledgeSkill ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Requirements_analysis", "10011007.10011074.10011075.10011076", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS02");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Analytical_and_Critical_Thinking","", FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C1KS03");		
		c.addKnowledgeSkill(ks);
				
		task.addCompetency(c);
		
		
		c = new Competency();
		c.setStatement("Determinar quando usar um AFD ou um AFND");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Investigativo"));
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Proativo"));
		c.setUri("C2");
		c.setType(LOMC.AtomicCompetence);		
		
		k = new Knowledge("Finite_state_machines","", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C2KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Analytical_and_Critical_Thinking","",FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C2KS02");		
		c.addKnowledgeSkill(ks);		
		
		task.addCompetency(c);	
		
		
		c = new Competency();
		c.setStatement("Testar autômatos usando o JFlap.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Investigativo"));
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Proativo"));
		c.addDisposition(new Disposition("Criativo"));
		c.setUri("C3");
		c.setType(LOMC.AtomicCompetence);		
		
		k = new Knowledge("Finite_state_machines","", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C3KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Problem_Solving_and_Trouble-Shooting", "", FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C3KS02");		
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);
		

		c = new Competency();
		c.setStatement("Determinar Expressões Regulares que representam Autômatos.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Investigativo"));
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Proativo"));
		c.addDisposition(new Disposition("Criativo"));
		c.setUri("C4");
		c.setType(LOMC.AtomicCompetence);
		
		k = new Knowledge("Finite_state_machines","", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C4KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Regular_languages", "", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C4KS02");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Analytical_and_Critical_Thinking","",FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C4KS03");		
		c.addKnowledgeSkill(ks);		
		
		task.addCompetency(c);
		
		
		c = new Competency();
		c.setStatement("Relacionar Expressões Regulares com Autômatos Finitos.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Investigativo"));
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Responsável"));
		c.addDisposition(new Disposition("Proativo"));
		c.addDisposition(new Disposition("Criativo"));
		c.setUri("C5");
		c.setType(LOMC.AtomicCompetence);
		
		k = new Knowledge("Finite_state_machines","", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C5KS01");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Regular_languages", "", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C5KS02");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Analytical_and_Critical_Thinking","",FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C5KS03");		
		c.addKnowledgeSkill(ks);		
		task.addCompetency(c);
		
		
		c = new Competency();
		c.setStatement("Escrever, em grupo, um relatório técnico.");
		c.setStatementLanguage("pt");		
		c.addDisposition(new Disposition("Colaborativo"));		
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));		
		c.setUri("C6");
		c.setType(LOMC.AtomicCompetence);

		k = new Knowledge("Written_Communication", "", FPK.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("C6KS01");
		c.addKnowledgeSkill(ks);
		
		task.addCompetency(c);
	
		return task;
	}

}