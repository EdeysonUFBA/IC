package cso;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestCSOParser {
    static CSOParser rCSO = new CSOParser();	
    
	public static void main(String[] args) {

	    ArrayList<String> rootNodes;
	    Topic node, child;
	    
	    //rCSO.showHash();
	    ArrayList<Topic> firstLevelNodes = rCSO.getFirstLevelNodes();
	    for (Topic topic : firstLevelNodes) {
	    		System.out.println(topic.getDescription());
	    }
	
//	    for (ACMCCSConcept concept : firstLevelNodes) {
//	    	imprimeHierarquia(concept, "");
//	    }	    
	    
	}

	public static void imprimeHierarquia(Topic node, String desloca) {
		desloca = desloca + "\t";
		Topic child;
		
//    	System.out.print(desloca + node.getCode());		    	
//    	System.out.println(" - " + node.getPerfLabel());
    	
/*		if (node.getNarrower().size() > 0) {
		    for (Object code : node.getNarrower()) {
		    	child = rCSO.getMapaCCS().get(code);
		    	imprimeHierarquia(child, desloca);
		    }			
		}
*/
	}	
}
