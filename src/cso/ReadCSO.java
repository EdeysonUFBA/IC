package cso;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class ReadCSO {
	static Model model;
	
    public static void main(String[] args) {
        String ontologyFile = "cso.3.3.owl"; // Substitua pelo caminho do seu arquivo RDF

        model = FileManager.get().loadModel(ontologyFile);
        Resource computerScience = model.getResource("https://cso.kmi.open.ac.uk/topics/computer_science");

        if (computerScience != null) {
            printHierarchy(computerScience, 0);
        } else {
            System.out.println("Nó 'Computer Science' não encontrado no modelo.");
        }
    }

    private static void printHierarchy(Resource topic, int depth) {
        // Imprime o nome do tópico com base na profundidade
        System.out.println(getIndentation(depth) + topic.getProperty(RDFS.label).getString());

        // Obtém todas as subcategorias usando a propriedade superTopicOf
        StmtIterator subCategories = topic.listProperties(model.getProperty("http://cso.kmi.open.ac.uk/schema/cso#superTopicOf"));

        while (subCategories.hasNext()) {
            Statement subCategoryStmt = subCategories.next();
            Resource subCategory = subCategoryStmt.getObject().asResource();

            // Chamada recursiva para imprimir as subcategorias
            printHierarchy(subCategory, depth + 1);
        }
    }

    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  "); // Use dois espaços para cada nível de profundidade
        }
        return indentation.toString();
    }
}
