package userInterface;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import cs2013.BoKCS2013Parser;
import cs2013.KnowledgeArea;
import cs2013.KnowledgeUnit;
import cs2013.Topic;


public class ACMCS2013Tree extends JTree{

    BoKCS2013Parser parser;
    
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
	ArrayList<KnowledgeArea> areas;
	ArrayList<KnowledgeUnit> units;
	ArrayList<Topic> topics, topicsN1, topicsN2;    
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;
    private static DefaultMutableTreeNode top = new DefaultMutableTreeNode("ACM CS BoK 2013");;

    public ACMCS2013Tree() {
        super(top);
        createNodes(top);

        this.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

    }

    private void createNodes(DefaultMutableTreeNode top) {
	    parser = new BoKCS2013Parser();
	    areas = parser.getBoKCS2013();
	    
	    areas.sort(null);
		for (KnowledgeArea knowledgeArea : areas) {
			//System.out.println(knowledgeArea.getName());
	        DefaultMutableTreeNode acmTreeNodeArea = new DefaultMutableTreeNode(knowledgeArea.getName());     
	        top.add(acmTreeNodeArea);			
			
			units = knowledgeArea.getKnowledgeUnits();
			units.sort(null);
			for (KnowledgeUnit knowledgeUnit : units) {
		        DefaultMutableTreeNode acmTreeNodeUnit = new DefaultMutableTreeNode(knowledgeUnit.getName());     
		        acmTreeNodeArea.add(acmTreeNodeUnit);				
				//System.out.println("\t" + knowledgeUnit.getName());
				topics = knowledgeUnit.getTopics();
				topics.sort(null);
				for (Topic topic : topics) {
			        DefaultMutableTreeNode acmTreeNodeTopic = new DefaultMutableTreeNode(topic.getDescricao());     
			        acmTreeNodeUnit.add(acmTreeNodeTopic);					
					//System.out.println("\t\t" + topic.getDescricao());
					topicsN1 = topic.getSubtopic();
					topicsN1.sort(null);
					for (Topic topicN1 : topicsN1) {
				        DefaultMutableTreeNode acmTreeNodeTopicN1 = new DefaultMutableTreeNode(topicN1.getDescricao());     
				        acmTreeNodeTopic.add(acmTreeNodeTopicN1);						
						//System.out.println("\t\t\t" + topicN1.getDescricao());
						topicsN2 = topicN1.getSubtopic();
						topicsN2.sort(null);
						for (Topic topicN2 : topicsN2) {
					        DefaultMutableTreeNode acmTreeNodeTopicN2 = new DefaultMutableTreeNode(topicN2.getDescricao());     
					        acmTreeNodeTopicN1.add(acmTreeNodeTopicN2);								
							//System.out.println("\t\t\t\t" + topicN2.getDescricao());
						}
					}
					
				}
			}
		}
		
     }
    

}
