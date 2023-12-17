package testesOntologyKSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Parser que lê o arquivo acm_ccs2012.xml e extrai seus elementos.
 *
 */
public class ParserOntologyKSA {
	static final String pathDir = "C:\\Users\\edeys\\Meu Drive (edeysongomes@ufba.br)\\Doutorado\\Projetos\\Ontologia CHA\\";
	static final String inputFileName = pathDir + "CompetenciasKSA.ttl";
	static final String outputFileName = pathDir + "CompetenciasKSA-out.ttl";
	
	public static void main(String[] args) {
		parser();

	}
	
	private static void parser() {
		boolean ehAtitude = false;

		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(inputFileName);
			FileWriter arqSaida = new FileWriter(outputFileName, StandardCharsets.UTF_8);
			
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine().trim(); 
			String comentario;
			while (linha != null) {
				if (linha.contains(":Attitude rdf:type"))
					ehAtitude = true;
				else if (ehAtitude)
					if (linha.contains("comment")) {
						//System.out.printf("[Comment]: " + linha + "\n");						
						comentario = "\"Teste 2 de adição de comentário!! \" @pt, ";
						linha = addComment(linha, comentario);
						//System.out.printf("[Comment]: " + linha + "\n");
						ehAtitude = false;
					}
				//else
					//System.out.printf(linha + "\n");

				arqSaida.write(linha + "\n");
				linha = lerArq.readLine(); 
			}
			arq.close();
			arqSaida.close();
			System.out.println("FIM...");
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",	e.getMessage());
		}

		System.out.println();
	}
	
	public static ArrayList selectRootNodes() {
		boolean ehNivel1 = false;
		ArrayList root = new ArrayList();
		
		try {
			FileReader arq = new FileReader(inputFileName);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine().trim(); 
			while (linha != null) {
				if (linha.contains("<skos:ConceptScheme"))
					ehNivel1 = true;
				else if (linha.contains("ConceptScheme>"))
					ehNivel1 = false;
				else if (ehNivel1)
					if (linha.contains("resource"))
						//root.add(getResource(linha));
						//System.out.printf("[1]: (" + getResource(linha) + ")\n");
					//else
						System.out.printf("[1]: " + linha + "\n");
				else
					System.out.printf(linha + "\n");

				linha = lerArq.readLine(); 
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",	e.getMessage());
		}

		return root;
	}


	
	private static String addComment(String s, String newComment) {
		int inicio, fim;
		String ret, rdf;
		
		inicio = s.indexOf('"');
		fim = s.indexOf('"', inicio+1);
		rdf = s.substring(0, inicio);
		
		ret = rdf + newComment + s.substring(inicio);
		return ret;
	}
}
