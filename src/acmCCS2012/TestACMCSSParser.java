package acmCCS2012;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestACMCSSParser {
    static ACMCCSParser rACM = new ACMCCSParser();	
    
	public static void main(String[] args) {

	    ArrayList<String> rootNodes;
	    ACMCCSConcept node, child;
	    
	    //rACM.showHash();
	    ArrayList<ACMCCSConcept> firstLevelNodes = rACM.getFirstLevelNodes();
	    for (ACMCCSConcept concept : firstLevelNodes) {
	    		System.out.println(concept.getCode() + ": " + concept.getPerfLabel());
	    }
	
//	    for (ACMCCSConcept concept : firstLevelNodes) {
//	    	imprimeHierarquia(concept, "");
//	    }	    
	    
	}

	public static void imprimeHierarquia(ACMCCSConcept node, String desloca) {
		desloca = desloca + "\t";
		ACMCCSConcept child;
		
    	System.out.print(desloca + node.getCode());		    	
    	System.out.println(" - " + node.getPerfLabel());
    	
		if (node.getNarrower().size() > 0) {
		    for (Object code : node.getNarrower()) {
		    	child = rACM.getMapaCCS().get(code);
		    	imprimeHierarquia(child, desloca);
		    }			
		}
	}
}
