package writeRDFPBL;

public class testTaskRDFReader {

	public static void main(String[] args) {
		TaskRDFReader reader = new TaskRDFReader();
		
		Task task = reader.readTask();
		
		System.out.println("Title: " + task.getTitle());
		System.out.println("Type: " + task.getType());
		System.out.println("Other Platform Requirements: " + task.getOtherPlatformRequirements());
		System.out.println("Aggregation Level: " + task.getAggregationLevel());
		System.out.println("Copyright: " + task.getCopyright());
		System.out.println("Cost: " + task.getCost());
		System.out.println("Keywords: " + task.getKeywords());
		System.out.println("Meta-Metadata Language: " + task.getMetaMetadataLanguage());
		System.out.println("Structure: " + task.getStructure());
		System.out.println("Language: " + task.getLanguage());
		for (Author author: task.getAuthors()) {
			System.out.println("Author: " + author);			
		}
		System.out.println("Creation Date: " + task.getCreationDate());
		System.out.println("Contributors: " + task.getContributors());
		System.out.println("Educational Context: " + task.getEducationalContext());
		System.out.println("Learning Resource Type: " + task.getLearningResourceType());
		System.out.println("Educational Description: " + task.getEducationalDescription());
		
		for (Competency competency : task.getCompetencies()) {
			System.out.println(competency.getUri());
			System.out.println(competency.getStatement() + " \"" + competency.getStatementLanguage() + "\"");			
		}
	}

}
